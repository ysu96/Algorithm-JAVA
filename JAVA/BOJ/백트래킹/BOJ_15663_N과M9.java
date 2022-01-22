package JAVA.BOJ.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_15663_N과M9 {
    public static int N,M;
    public static int[] arr, tmp;
    public static boolean[] visited;
    public static Set<String> set;
    // LinkedHashSet : 입력 순 정렬
    // TreeSet : Comparator 또는 오름차순 정렬
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        visited = new boolean[N];
        tmp = new int[M];
        set = new LinkedHashSet<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        back(0);
        set.forEach(System.out::println);
    }

    public static void back(int idx){
        if(idx == M){
            StringBuilder sb = new StringBuilder();
            for (int i : tmp) {
                sb.append(i).append(" ");
            }
            set.add(sb.toString());
            return;
        }

        for(int i=0; i<N; i++){
            if(visited[i]) continue;
            tmp[idx] = arr[i];
            visited[i] = true;
            back(idx + 1);
            visited[i] = false;
        }
    }
}
