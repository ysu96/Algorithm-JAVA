package JAVA.Programmers.src.KAKAO2022;

import java.util.Arrays;

//1시간 17분걸림  쒯
public class p4_양궁대회 {
    public int[] answer, ryan;
    public int maxScore;

    public int[] solution(int n, int[] info) {
        answer = new int[11];
        ryan = new int[11];
        round(10, info, n);
        if(maxScore <= 0){
            return new int[]{-1};
        }
        return answer;
    }

    public void round(int score, int[] info, int arrow) {
        int idx = 10 - score;
        if (idx > 10) {
            // 점수 차 계산
            int cal = calculate(info, ryan);
            if(cal < 0) return;

            if(maxScore == cal){
//                print(ryan);
                for(int i=10; i>=0; i--){
                    if(ryan[i] > answer[i]){
                        answer = Arrays.copyOf(ryan, ryan.length);
                        return;
                    } else if (answer[i] > ryan[i]) {
                        return;
                    }
                }
            }

            if(maxScore < cal){
//                print(ryan);
                maxScore = cal;
                answer = Arrays.copyOf(ryan, ryan.length);
            }
            return;
        }

        if(idx == 10){
            ryan[idx] = arrow;
            round(score - 1, info, 0);

        }else{
            if (info[idx] != 0) {
                //1 이기기
                if (arrow > info[idx]) {
                    ryan[idx] = info[idx] + 1;
                    round(score - 1, info, arrow - ryan[idx]);
                }
                //2 포기하기
                ryan[idx] = 0;
                round(score - 1, info, arrow);

            } else {
                // 1 이기기
                if (arrow > 0) {
                    ryan[idx] = 1;
                    round(score - 1, info, arrow-1);
                }

                ryan[idx] = 0;
                round(score - 1, info, arrow);
            }
        }

    }

    public int calculate(int[] apeach, int[] ryan) {
        int a = 0, r = 0;
        for (int i = 0; i < 11; i++) {
            if(apeach[i] == 0 && ryan[i] == 0) continue;

            if(apeach[i] >= ryan[i]){
                a += 10 - i;
            }else{
                r += 10 - i;
            }
        }
        return r-a;
    }


    public void print(int[] arr){
        StringBuilder sb = new StringBuilder();
        for(int i : arr){
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) {
        p4_양궁대회 p4 = new p4_양궁대회();
        int[] solution = p4.solution(5, new int[]{2,1,1,1,0,0,0,0,0,0,0});
        for (int i : solution) {
            System.out.println(i);
        }
    }
}
