package 알고리즘기초;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

//************* 수 찾기 *****************
//map쓰는 버전
public class B1920_수찾기 {
    private static int N;
    private static int M;
    private static Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());


        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            int number = Integer.parseInt(st.nextToken());
            map.put(number, 1);
        }

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            int number = Integer.parseInt(st.nextToken());
            if(map.containsKey(number)) System.out.println(1);
            else System.out.println(0);
        }

    }
}

//public class B1920 {
//    private static int N;
//    private static int M;
//    private static int[] A;
//    private static int[] Q;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
//        st = new StringTokenizer(br.readLine());
//        N = Integer.parseInt(st.nextToken());
//        A = new int[N];
//
//        st = new StringTokenizer(br.readLine());
//        for(int i=0; i<N; i++){
//            A[i] = Integer.parseInt(st.nextToken());
//        }
//
//        st = new StringTokenizer(br.readLine());
//        M = Integer.parseInt(st.nextToken());
//        Q = new int[M];
//
//        st = new StringTokenizer(br.readLine());
//        for(int i=0; i<M; i++){
//            Q[i] = Integer.parseInt(st.nextToken());
//        }
//
//        //sorting
//        Arrays.sort(A);
//        for(int i=0; i<M;i++){
//            System.out.println(binary_search(Q[i]));
//        }
//
//    }
//
//    //있으면 1 없으면 0
//    public static int binary_search(int key){
//        int left, right, mid;
//        left = 0;
//        right = N-1;
//        while(left <= right){
//            mid = (left+right)/2;
//            if(A[mid] == key) return 1;
//            else if(key < A[mid]){
//                right = mid-1;
//            }
//            else{
//                left = mid+1;
//            }
//        }
//        return 0;
//    }
//}
