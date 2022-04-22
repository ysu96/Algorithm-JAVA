package JAVA.BOJ.삼성SW역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_5656_벽돌깨기 {
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 1~4
            int W = Integer.parseInt(st.nextToken());  // 2~12
            int H = Integer.parseInt(st.nextToken()); // 2~15
            int[][] arr = new int[H][W];
            answer = 0;
            int sum = 0;

            for(int i=0; i<H; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<W; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    if(arr[i][j] != 0) sum++;
                }
            }

            // 벽돌 던질 수 있는 경우의 수 : W^N : 12^4 = 20736
            dfs(0, N, W,0, arr);
//            System.out.println(sum);
            System.out.println("#" + tc + " " + (sum-answer));
        }
    }

    public static void dfs(int n, int N, int W, int cnt, int[][] arr){

        if(n == N){
            answer = Math.max(answer, cnt);

//            printArr(arr);
            return;
        }

        // 0~W까지 다 벽돌 내려보기
        for(int i=0; i<W; i++){
            int[][] copy = copyArr(arr);
            //System.out.println(i);
            // 벽돌 깨기
            int num = breakOut(copy, i);
            //printArr(copy);
            //아래로 푸시
            push(copy);
            //printArr(copy);

            dfs(n+1, N, W, cnt+num, copy);

        }
    }

    public static void push(int[][] arr){
        for(int i=0; i<arr[0].length; i++){
            for(int j=arr.length-1; j >= 0; j--){
                if(arr[j][i] != 0){
                    int loc = j;
                    if(loc == arr.length-1 || arr[loc+1][i] != 0) continue;

                    while (loc < arr.length) {
                        if(loc == arr.length-1){
                            arr[loc][i] = arr[j][i];
                            arr[j][i] = 0;
                            break;
                        }

                        if(arr[loc+1][i] != 0){
                            arr[loc][i] = arr[j][i];
                            arr[j][i] = 0;
                            break;
                        }
                        loc++;
                    }
                }
            }
        }
    }

    public static int[][] copyArr(int[][] arr){
        int[][] tmp = new int[arr.length][arr[0].length];
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                tmp[i][j] = arr[i][j];
            }
        }
        return tmp;
    }

    public static int breakOut(int[][] arr, int loc){
        int cnt = 0;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[arr.length][arr[0].length];
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, 1, -1};

        for(int i=0; i<arr.length; i++){
            if(arr[i][loc] != 0){
                // 벽돌 부수기 시작
                int n = arr[i][loc];
                q.add(new int[]{i, loc, n});
                arr[i][loc] = 0;
                visited[i][loc] = true;
                break;
            }
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            int n = cur[2];
            cnt++;
            if(n == 1) {
                continue;
            }
// 5,6 start
            // 4,6
            //6,6
            //5,5
            // 5,7
            for(int i=0; i<4; i++){
                for(int j=1; j<n; j++){
                    int nr = r + dr[i]*j;
                    int nc = c + dc[i]*j;
//                    if(loc == 6){
//                        System.out.println("" + nr + "" + nc);
//                        printArr(arr);
//                    }
                    if (nr < 0 || nc < 0 || nr >= arr.length || nc >= arr[0].length) continue;
                    if(visited[nr][nc] || arr[nr][nc] == 0) continue;
                    q.add(new int[]{nr, nc, arr[nr][nc]});
                    visited[nr][nc] = true;
                    arr[nr][nc] = 0;
//                    if(loc == 6){
//                        System.out.println("" + nr + "" + nc);
//                        printArr(arr);
//                    }
                }
            }
        }
//        System.out.println("TESTSETSET");
//        printArr(arr);
        return cnt;
    }

    public static void printArr(int[][] arr){
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                System.out.print(""+arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
