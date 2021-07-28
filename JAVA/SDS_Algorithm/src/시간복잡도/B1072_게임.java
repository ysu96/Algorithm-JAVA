package 시간복잡도;
import java.io.*;
import java.util.*;

public class B1072_게임 {
    private static long X, Y, Z;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        X = Long.parseLong(st.nextToken());
        Y = Long.parseLong(st.nextToken());

        Z = Y * 100 / X;
        if (Z == 100 || Z == 99) {
            System.out.println(-1);
            return;
        }
        // 이분 탐색으로 진행
        long bottom = 1, top = 1000000000, mid;
        long answer = 1000000000;
        while (bottom <= top) {
            mid = (bottom + top) / 2;
            long nextZ = (Y + mid) * 100 / (X + mid);
            if (Z < nextZ) {
                if (mid < answer) {
                    answer = mid;
                }
                top = mid - 1;
            }
            else {
                bottom = mid + 1;
            }
        }
        System.out.println(answer);
        //System.out.println("Z : " + Z);
        //System.out.println("NEXT Z : " + (Y + answer) * 100 / (X + answer));
        /*
        // 경기횟수가 정수 범위를 벗어 난다면??????
        for (int i = 1 ; ; i++) {
            long nextZ = (Y + i) * 100 / (X + i);
            double tmp = (double)(Y + i) * 100 / (X + i);
            System.out.println(tmp);
            if (nextZ != Z) {
                System.out.println(i);
                break;
            }
        }
        */
    }
}