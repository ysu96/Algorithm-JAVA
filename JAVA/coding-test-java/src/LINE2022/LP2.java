package LINE2022;

public class LP2 {
    static int[][] needs;
    static int[] scores;
    static int answer;

    //배열 길이 15
    // 원소 길이 10만
    public int solution(String[] sentences, int n) {
        needs = new int[sentences.length][27]; //27번째는 시프트키
        scores = new int[sentences.length];
        answer = 0;

        // 문장별 점수, 문장 별 필요한 키 구하기
        for (int i=0; i<sentences.length; i++) {
            String str = sentences[i];
            for(int j=0; j<str.length(); j++){
                char c = str.charAt(j);
                if('A' <= c && c <= 'Z'){
                    scores[i]++;
                    needs[i][26] = 1; // shift key
                    needs[i][c-'A'] = 1;
                }
                else if('a' <= c && c <= 'z'){
                    needs[i][c-'a'] = 1;
                }
                scores[i]++;
            }
        }
        int[] need = new int[27];
        dfs(0, need, 0, sentences.length, n);
        System.out.println(answer);
        // s : sentences 길이
        return answer;
    }

    public void dfs(int x, int need[], int score, int s, int n){
        // 문장 다 돌았으면
        if (x == s) {
            int cnt = 0;
            for (int i = 0; i <= 26; i++) {
                if (need[i] >= 1) cnt += 1;
            }
            // 필요한 문자 수가 n개 이하면
            if (cnt <= n) {
                answer = Math.max(answer, score);
            }
            return;
        }

        // x번 문자열을 고르는 경우
        for (int i = 0; i <= 26; i++) {
            need[i] += needs[x][i];
        }
       dfs(x + 1, need, score + scores[x], s, n);

        // x번 문자열을 고르지 않는 경우
        for (int i = 0; i <= 26; i++) {
            need[i] -= needs[x][i];
        }
        dfs(x + 1, need, score, s, n);
    }

    public static void main(String[] args) {
        LP2 lp2 = new LP2();
        String[] sen = new String[]{"line in line", "LINE", "in lion"};
        String[] sen2 = new String[]{"ABcD", "bdbc", "a", "Line neWs"};
        lp2.solution(sen, 5);
        lp2.solution(sen2, 7);
    }
}
