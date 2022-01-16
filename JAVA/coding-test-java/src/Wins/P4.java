package Wins;

public class P4 {
    public int solution(int[] mails, int period, int K){
        int answer = 0;
        // mail 3~200000
        // period 2~mail
        // K 0~10000
        int sum = 0;
        int cnt = 0;
        int first = 0;

        for (int mail : mails) {
            sum += mail;
            cnt++;
            if (cnt == period) {
                if (sum / period >= K) answer++;
                sum -= mails[first];
                first++;
                cnt--;
            }
        }
        System.out.println(answer);
        return answer;
    }

    public static void main(String[] args) {
        P4 p4 = new P4();
        p4.solution(new int[]{9,20, 10, 30, 23, 4}, 3, 20);
    }
}
