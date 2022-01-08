package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

//거짓말
public class BOJ_1043 {
    public static int N, M, T;
    public static int[] people; // 0 : 무지, 1 : 진실, 2 : 거짓
    public static List<Integer>[] party;
    public static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        people = new int[N + 1];
        party = new List[M];
        for (int i = 0; i < M; i++) {
            party[i] = new LinkedList<>();
        }
        st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= T; i++) {
            people[Integer.parseInt(st.nextToken())] = 1;
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            for (int j = 0; j < num; j++) {
                int a = Integer.parseInt(st.nextToken());
                party[i].add(a);
            }
        }

        for(int i=0; i<M; i++){
            if(checkTrue(i)){
                for(int j=0; j<party[i].size(); j++){
                    people[party[i].get(j)] = 1;
                }
            }
        }
        for(int i=0; i<M; i++){
            if(checkTrue(i)){
                for(int j=0; j<party[i].size(); j++){
                    people[party[i].get(j)] = 1;
                }
            }
        }
        for(int i=0; i<M; i++){
            if(!checkTrue(i)){
                answer++;
            }
        }
//        solution(0, 0);
        System.out.println(answer);
    }

    public static boolean checkTrue(int idx) {
        for (int i = 0; i < party[idx].size(); i++) {
            int a = party[idx].get(i);
            if (people[a] == 1) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkFalse(int idx) {
        for (int i = 0; i < party[idx].size(); i++) {
            int a = party[idx].get(i);
            if (people[a] == 2) {
                return true;
            }
        }
        return false;
    }

    public static void solution(int idx, int cnt) {
        if(idx == M){
            answer = Math.max(answer, cnt);
            return;
        }

        if (checkTrue(idx) && checkFalse(idx)) {
            solution(idx + 1, cnt);
        } else if (checkTrue(idx)) {
            for(int i=0; i<party[idx].size(); i++){
                people[party[idx].get(i)] = 1;
            }
            solution(idx+1, cnt);
            for(int i=0; i<party[idx].size(); i++){
                people[party[idx].get(i)] = 0;
            }
        } else {
            for(int i=0; i<party[idx].size(); i++){
                people[party[idx].get(i)] = 2;
            }
            solution(idx+1, cnt+1);
            for(int i=0; i<party[idx].size(); i++){
                people[party[idx].get(i)] = 0;
            }
        }

        // 진실
        if(checkTrue(idx)){
            for(int i=0; i<party[idx].size(); i++){
                people[party[idx].get(i)] = 1;
            }
            solution(idx+1, cnt);
            for(int i=0; i<party[idx].size(); i++){
                people[party[idx].get(i)] = 0;
            }
        }
        // 과장

    }
}
