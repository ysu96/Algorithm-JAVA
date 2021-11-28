package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_14891_톱니바퀴 {
    public static int k;
    public static int[][] lists = new int[4][8];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0; i<4; i++){
            String str = br.readLine();
            for(int j =0; j<8; j++){
                lists[i][j]=Integer.parseInt(String.valueOf(str.charAt(j)));
//                System.out.println(deques[i].toString());
            }
        }

        k = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i=0; i<k; i++){
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken())-1;
            int dir = Integer.parseInt(st.nextToken());


            //인덱스 6, 2이 맞닿아있음

            //오른쪽부터
            int statR = lists[idx][2];
            int statL = lists[idx][6];
            if(dir == -1) rotateR(idx);
            else rotateL(idx);

            int idx2 = idx;
            int dir2 = dir;
            while(idx2 < 3){
                int left = lists[idx2+1][6];
                int right = lists[idx2+1][2];
                //극이 다르면 회전
                if (statR != left) {
                    //오른쪽애는 시계회전
                    if(dir2 == 1){
                        rotateR(idx2 + 1);
                        dir2 = -1;
                    }else{
                        rotateL(idx2 + 1);
                        dir2 = 1;
                    }
                }
                //극 같으면 끝
                else{
                    break;
                }
                statR = right;
                idx2++;
            }

            //왼쪽
            idx2 = idx;
            dir2 = dir;
            while(idx2 > 0){
                int left = lists[idx2-1][6];
                int right = lists[idx2-1][2];
                //극이 다르면 회전
                if (statL != right) {
                    //오른쪽애는 시계회전
                    if(dir2 == 1){
                        rotateR(idx2 - 1);
                        dir2 = -1;
                    }else{
                        rotateL(idx2 - 1);
                        dir2 = 1;
                    }
                }
                //극 같으면 끝
                else{
                    break;
                }
                statL = left;
                idx2--;
            }

//            for(int z=0; z<4; z++){
//                for(int j=0; j<8; j++){
//                    System.out.print(lists[z][j]);
//                }
//                System.out.println();
//            }
        }
        int answer =0;
        for(int i=0; i<4; i++){
            if(lists[i][0] == 1) answer += Math.pow(2, i);
        }
        System.out.println(answer);

//        for(int i=0; i<4; i++){
//            for(int j=0; j<8; j++){
//                System.out.print(lists[i][j]);
//            }
//            System.out.println();
//        }
    }

    public static void rotateL(int idx){
        for(int k = 7; k>=1; k--){
            int tmp = lists[idx][k-1];
            lists[idx][k-1] = lists[idx][k];
            lists[idx][k] = tmp;
        }
    }
    public static void rotateR(int idx){
        for(int k=0; k<=6; k++){
            int tmp = lists[idx][k+1];
            lists[idx][k+1] = lists[idx][k];
            lists[idx][k] = tmp;
        }
    }
}
