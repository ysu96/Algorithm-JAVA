package JAVA.BOJ.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//https://dragon-h.tistory.com/2
public class BOJ_12015_LIS2 {
    public static int N;
    public static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list.add(0);
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            int n = Integer.parseInt(st.nextToken());
            if (list.get(list.size() - 1) < n) {
                list.add(n);
            } else {
                int start = 0;
                int end = list.size()-1;
                while (start < end) {
                    int mid = (start + end) / 2;
                    if(list.get(mid) >= n) end = mid;
                    else start = mid+1;
                }
                list.set(end, n);
            }
        }
        System.out.println(list.size() - 1);
    }
}
