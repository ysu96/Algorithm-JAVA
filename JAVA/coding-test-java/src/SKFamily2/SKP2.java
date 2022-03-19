package SKFamily2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SKP2 {
    class P implements Comparable<P> {
        int idx;
        boolean read;
        int t1;
        int t2;
        int A;
        int B;
        int C;
        int endTime;

        P(int idx, boolean read, int t1, int t2, int A, int B) {
            this.idx = idx;
            this.read = read;
            this.t1 = t1;
            this.t2 = t2;
            this.A = A;
            this.B = B;
        }

        P(int idx, boolean read, int t1, int t2, int A, int B, int C) {
            this.idx = idx;
            this.read = read;
            this.t1 = t1;
            this.t2 = t2;
            this.A = A;
            this.B = B;
            this.C = C;
        }

        @Override
        public int compareTo(P o) {
            if (!this.read) {
                if (o.read) return -1;
                else {
                    if (this.t1 < o.t1) return -1;
                    else return 1;
                }
            } else {
                if (!o.read) return 1;
                else {
                    if (this.t1 < o.t1) return -1;
                    else return 1;
                }
            }
        }
    }

    boolean[] isReading;
    boolean[] isWriting;
    List<P>[] waiting;
    List<P>[] working;
    int len;

    public String[] solution(String[] arr, String[] processes) {
        String[] answer = {};
        List<String> ans = new ArrayList<>();
        String[] tmp = new String[processes.length];

        isReading = new boolean[arr.length];
        isWriting = new boolean[arr.length];

        waiting = new List[arr.length];
        working = new List[arr.length];
        for (int i = 0; i < arr.length; i++) {
            waiting[i] = new ArrayList<>();
            working[i] = new ArrayList<>();
        }


        int time = 0;
        int workingtime = 0;
        int idx = 0;
        len = arr.length;
        while (true) {
            time++;
            if(isWorking()) workingtime++;

            // working 에서 종료된거 찾기
            for (int i = 0; i < len; i++) {
                for (int k=0; k<working[i].size(); k++) {
                    P w = working[i].get(k);
                    boolean success = false;

                    if (time == w.endTime) {
                        if (w.read) {
                            tmp[w.idx] = getString(arr, w);
                            for (int j = w.A; j <= w.B; j++) isReading[j] = false;

                        } else { //쓰기
                            for (int j = w.A; j <= w.B; j++) {
                                arr[j] = Integer.toString(w.C);
                                isWriting[j] = false;
                            }
                        }

                        working[i].remove(w);
                        success = true;
                    }
                    if(success) k--;
                    if(working[i].size() == 0) break;
                }
            }

            //상태 업데이트
            updateStatus();

            //종료
            if(idx >= processes.length && isComplete()){
                break;
            }

            // 추가할 프로세스 있으면 추가
            if(idx < processes.length){
                P cur = parseProcess(processes[idx], idx);
                if (cur.t1 == time) {
                    for(int i=cur.A; i<=cur.B; i++){
                        waiting[i].add(cur);
                    }
                    idx++;
                }
            }

            //waiting에서 실행할거 찾기
            for (int i = 0; i < len; i++) {
                Collections.sort(waiting[i]);
            }

            for (int i = 0; i < len; i++) {
                for (int k=0; k<waiting[i].size(); k++) {
                    P w = waiting[i].get(k);
                    boolean success = false;

                    if(w.read && !isReadable(w)) continue;
                    if(!w.read && !isWritable(w)) continue;

                    //순서 확인
                    boolean turn = true;
                    for(int j=w.A; j<=w.B; j++){
                        if(!waiting[j].get(0).equals(w)){
                            turn = false;
                            break;
                        }
                    }

                    if(turn){
                        for(int j=w.A; j<=w.B; j++){
                            waiting[j].remove(w);
                            if(w.read) isReading[j] = true;
                            else isWriting[j] = true;
                        }

                        w.endTime = time + w.t2;
                        working[w.A].add(w);
                        success = true;
                    }

                    if(success) k--;
                    if(waiting[i].size() == 0) break;
                }
            }
        }
        for(int i=0; i<processes.length; i++){
            if(tmp[i] != null){
                ans.add(tmp[i]);
            }
        }
        ans.add(Integer.toString(workingtime));

        answer = new String[ans.size()];
        for(int i=0; i<ans.size(); i++){
            answer[i] = ans.get(i);
        }

        return answer;
    }

    public void updateStatus(){
        for (int i = 0; i < len; i++) {
            for (int k = 0; k < working[i].size(); k++) {
                P w = working[i].get(k);
                if (w.read) {
                    for (int j = w.A; j <= w.B; j++) isReading[j] = true;
                } else {
                    for (int j = w.A; j <= w.B; j++) isWriting[j] = true;
                }
            }
        }
    }

    public String getString(String[] arr, P w) {
        StringBuilder sb = new StringBuilder();
        for (int j = w.A; j <= w.B; j++) {
            sb.append(arr[j]);
        }
        return sb.toString();
    }

    public boolean isWorking(){
        for (int i = 0; i < len; i++) {
            if (isWriting[i]) return true;
            if (isReading[i]) return true;
        }
        return false;
    }

    public boolean isComplete(){
        for (List<P> works : working) {
            if(works.size() != 0) return false;
        }
        for (List<P> waits : waiting) {
            if(waits.size() != 0) return false;
        }
        return true;
    }

    public boolean isWritable(P cur) {
        for (int i = cur.A; i <= cur.B; i++) {
            if (isWriting[i]) return false;
            if (isReading[i]) return false;
        }
        return true;
    }

    public boolean isReadable(P cur) {
        for (int i = cur.A; i <= cur.B; i++) {
            if (isWriting[i]) return false;
        }
        return true;
    }

    public P parseProcess(String process, int idx) {
        String[] ops = process.split(" ");
        boolean read = ops.length <= 5;
        int t1 = Integer.parseInt(ops[1]);
        int t2 = Integer.parseInt(ops[2]);
        int A = Integer.parseInt(ops[3]);
        int B = Integer.parseInt(ops[4]);
        int C;
        if (read) {
            return new P(idx, read, t1, t2, A, B);
        } else {
            C = Integer.parseInt(ops[5]);
            return new P(idx, read, t1, t2, A, B, C);
        }
    }

    public static void main(String[] args) {
        SKP2 p2 = new SKP2();
        String[] arr = {"1","2","4","3","3","4","1","5"};
        String[] processes = {"read 1 3 1 2","read 2 6 4 7","write 4 3 3 5 2","read 5 2 2 5","write 6 1 3 3 9", "read 9 1 0 7"};
        String[] arr2 = {"1","1","1","1","1","1","1"};
        String[] processes2 = {"write 1 12 1 5 8","read 2 3 0 2","read 5 5 1 2","read 7 5 2 5","write 13 4 0 1 3","write 19 3 3 5 5","read 30 4 0 6","read 32 3 1 5"};
        String[] arr3 = {"1","1","1","1","1","1","1"};
        String[] processes3 = {"read 2 3 0 2", "write 3 12 0 5 8", "read 10 3 0 2", "read 25 3 0 2"};
        String[] solution = p2.solution(arr3, processes3);
        for (String s : solution) {
            System.out.print(s + " ");
        }
    }
}
