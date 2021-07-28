package 알고리즘기초;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class map{
    int r;
    int c;
    map(int r, int c){
        this.r = r;
        this.c = c;
    }
}
public class B3055_탈출 {
//    static int r;
//    static int c;
//    static char[][] map;
//    static int[] dr = {-1,-1,0,0};
//    static int[] dc = {0,0,-1,-1};
//    static Queue<map> ddg = new LinkedList<>();
//    static Queue<map> water = new LinkedList<>();
//    static int answer = 0;
//
//    public static boolean check_rc(int rr, int cc){
//        return (0<=rr && rr< r && 0<=cc && cc<c);
//    }
//
//    public static void bfs(){
//        while (!ddg.isEmpty()){
//            //water first
//            int water_size = water.size();
//            for(int i=0; i<water_size; i++){
//                map cur_water = water.poll();
//                for (int j = 0 ; j < 4 ; j++) { // 상/하/좌/우 순서대로 좌표를 얻는다
//                    int new_r, new_c;
//                    new_r = cur_water.r + dr[j];
//                    new_c = cur_water.c + dc[j];
//                    if (!check_rc(new_r, new_c)) continue;
//                    if (map[new_r][new_c] == 'D' || map[new_r][new_c] == 'X' || [new_r][new_c] != 0) continue;
//                    water_vt[new_r][new_c] = water_vt[cur_water.first][cur_water.second] + 1;
//                    water_q.push(pii(new_r, new_c));
//                }
//            }
//            map m = ddg.poll();
//            int cur_r = m.y;
//            int cur_c = m.x;
//
//        }
//    }

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String tc = br.readLine();
//        StringTokenizer st = new StringTokenizer(tc, " ");
//        r = Integer.parseInt(st.nextToken());
//        c = Integer.parseInt(st.nextToken());
//        map = new char[r][c];
//        int[][] water_visited = new int[r][c];
//        int[][] ddg_visited = new int[r][c];
//        for(int i=0;i<r;i++){
//            for(int j=0;j<c;j++){
//                water_visited[i][j] = 0;
//                ddg_visited[i][j] = 0;
//            }
//        }
//
//        for(int i =0; i<r; i++){
//            String str = br.readLine();
//            for(int j=0; j<c; j++){
//                map[i][j] = str.charAt(j);
//                if (str.charAt(j) == 'S') {
//                    ddg.add(new map(i,j));
//                    ddg_visited[i][j] = 1;
//                }
//                if (str.charAt(j) == '*'){
//                    water.add(new map(i,j));
//                    water_visited[i][j] = 1;
//                }
//            }
//        }
//
//        bfs();
//
////        for(int i=0; i<r; i++){
////            for(int j=0; j<c; j++){
////                System.out.print(map[i][j] + " ");
////            }
////            System.out.println();
////        }
//

    }
}
