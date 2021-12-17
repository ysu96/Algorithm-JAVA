package 이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1253_좋다 {
    public static int N;
    public static int[] arr;
    public static boolean[] visited;

    public static boolean binarySearch(int a, int start, int end){
        if(end<start) return false;
        int mid = (start+end)/2;
        if(arr[mid] == a && !visited[mid]) return true;
        else if(arr[mid] > a) return binarySearch(a, start, mid-1);
        else if(arr[mid] < a) return binarySearch(a, mid+1, end);
        else{
            for(int i=0; i<N; i++){
                if (arr[i] == a && !visited[i]){
                    return true;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int answer = 0;
        for(int i=0; i<N; i++){
            int tmp = arr[i];
            for(int j=0; j<N; j++){
                if(i==j) continue;
                visited = new boolean[N];
                visited[j] = true;
                visited[i] = true;
                if(binarySearch(tmp-arr[j], 0, N-1)){
                    answer++;
                    break;
                }
            }
        }
        System.out.println(answer);
    }
}
