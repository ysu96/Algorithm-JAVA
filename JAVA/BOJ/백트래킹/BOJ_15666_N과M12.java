package JAVA.BOJ.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_15666_N과M12 {
    public static int N,M;
    public static int[] arr, tmp;
    public static boolean[] visited;
    public static Set<String> set = new LinkedHashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        tmp = new int[M];
        visited = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        back(0, 0);
        set.forEach(System.out::println);
    }

    static void back(int n, int idx){
        if(idx == M){
            StringBuilder sb = new StringBuilder();
            for (int i : tmp) {
                sb.append(i).append(" ");
            }
            set.add(sb.toString());
            return;
        }
        for(int i=n; i<N; i++){
            tmp[idx] = arr[i];
            back(i, idx+1);
        }
    }

}
