package 네이버파이낸셜;

public class NF1 {
    public int[] solution(int[][] recruits, int s1, int s2) {
        int[][] dp = new int[101][101]; // 경력 x년 , y점 기준일 때 e1+e2의 값
        // e1+e2가 최대가 되게 expert 기준을 정해라
        // 단 주니어 > 시니어 > 엑스퍼트 순서대로 되게
        int maxE1 = 0;
        int maxScore = 0;
        int maxSum = 0;

        for(int i=0; i<=100; i++){
            for(int j=0; j<=100; j++){
                int e1 = i;
                int e2 = j;
                int junior = 0;
                int senior = 0;
                int expert = 0;
                for (int[] recruit : recruits) {
                    int year = recruit[0];
                    int score = recruit[1];
                    if(year >= e1 && score >= e2) expert++;
                    else if(year >= s1 || score >= s2) senior++;
                    else junior++;
                }
                if (0 < expert && expert < senior && senior < junior) {
                    dp[i][j] = e1 + e2;
                    if(maxSum < dp[i][j]){
                        maxSum = dp[i][j];
                        maxE1 = i;
                        maxScore = j;
                    }else if(maxSum == dp[i][j] && maxE1 < i){
                        maxE1 = i;
                        maxScore = j;
                    }
                }
            }
        }
        System.out.println(maxE1);
        System.out.println(maxScore);
        return new int[]{maxE1, maxScore};
    }

    public static void main(String[] args) {
        NF1 nf1 = new NF1();
        int[][] a= new int[][]{{1, 50}, {1, 60}, {3, 70}, {0, 65}, {2, 50}, {1, 90}};
        nf1.solution(a, 2, 70);
    }
}
