package SKFamily;

import java.math.BigInteger;

// dp[n+1][n+1] : dp[][] 까지 갈 수 있는 경로의 개수
// dp[0][0] = 1;
//
public class SK_p3 {
    int answer = 0;
    boolean[][] check;
    int[][] dp;
    int MOD = 10000019;

    public int solution(int width, int height, int[][] diagonals) {
        check = new boolean[height + 2][width + 2];
        for (int[] xy : diagonals) {
            check[xy[1]][xy[0]] = true;
        }

//        dfs(0,0,0,height, width, false);

        dp = new int[width + 1][height + 1];
        dp[0][0] = 1;
        for (int i = 0; i <= width; i++) {
            for (int j = 0; j <= height; j++) {
                if (i == 0 && j == 0) continue;

                dp[i][j] = 0;
                if (i > 0){
                    dp[i][j] += dp[i - 1][j];
                }
                if (j > 0) {
                    dp[i][j] += dp[i][j - 1];
                }
                dp[i][j] %= MOD;
            }
        }

        answer = 0;
        for (int[] diag : diagonals) {
            int x = diag[0];
            int y = diag[1];
            // O -> A -> B -> X;
            long cntAB = ((long) dp[x][y - 1] * dp[width - x + 1][height - y]) % MOD;

            // O -> B -> A -> X
            long cntBA = ((long) dp[x - 1][y] * dp[width - x][height - y + 1]) % MOD;
            answer += (cntAB + cntBA) % MOD;
            answer %= MOD;

        }

        return answer;
    }


    public int sol2(int height, int width, int[][] diagonals) {
        BigInteger answer = new BigInteger("0");
        BigInteger a, b, tmp, tmp2;

        // (height+width)! / height! * width!  * 대각선 개수?
        // 대각선 점까지의 최단경로  *  대각선 끝부터 끝점까지 최단경로
        for (int[] diag : diagonals) {
            int r = diag[0];
            int c = diag[1];
            // (r, c-1) , (r-1, c) 두 끝점, 시작 (0,0)

            // 1. (0,0) -> (r, c-1) 최단 경로 개수
            int h = r;
            int w = c - 1;
            a = new BigInteger("1");
            for (int i = h + 1; i <= h + w; i++) {
                a = a.multiply(new BigInteger(String.valueOf(i)));
            }
            b = new BigInteger("1");
            for (int i = 2; i <= w; i++) {
                b = b.multiply(new BigInteger(String.valueOf(i)));
            }
            tmp = a.divide(b);

            // 2. 대각선 도착점 (r-1, c) 부터 끝점까지 경로 개수
            h = height - (r - 1);
            w = width - c;
            a = new BigInteger("1");
            for (int i = h + 1; i <= h + w; i++) {
                a = a.multiply(new BigInteger(String.valueOf(i)));
            }
            b = new BigInteger("1");
            for (int i = 2; i <= w; i++) {
                b = b.multiply(new BigInteger(String.valueOf(i)));
            }
            tmp2 = a.divide(b);

            answer = answer.add(tmp.multiply(tmp2)).multiply(new BigInteger("2"));
            System.out.println(answer);
        }
        int ans = answer.mod(new BigInteger("10000019")).intValue();
        return ans;
    }

    public void dfs(int r, int c, int distance, int height, int width, boolean used) {
        if (r == height && c == width) {
            if (used && distance == height + width + 1) {
                answer++;
                answer %= 10000019;
            }
            return;
        }

        if (distance >= height + width + 1) {
            return;
        }
        if (r > height || c > height) {
            return;
        }

        //대각선 사용 안했으면
        if (!used) {
            if (check[r][c + 1]) {
                //대각선
                dfs(r - 1, c + 1, distance + 1, height, width, true);
            } else if (check[r + 1][c]) {
                dfs(r + 1, c - 1, distance + 1, height, width, true);
            }
        }
        //대각선 안타기
        dfs(r, c + 1, distance + 1, height, width, used);
        dfs(r + 1, c, distance + 1, height, width, used);
    }

    public static void main(String[] args) {
        SK_p3 p3 = new SK_p3();
//        System.out.println(p3.solution(2, 2, new int[][]{{1, 1}, {2, 2}}));
        System.out.println(p3.solution(51, 37, new int[][]{{17, 19}}));
        //51, 37, {{17, 19}} 3225685
    }
}
