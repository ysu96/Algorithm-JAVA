package JAVA.BOJ.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

//https://wellbell.tistory.com/46
public class BOJ_14003_LIS5 {
    public static int N;
    public static List<Integer> list = new ArrayList<>();
    public static int[] index, arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        index = new int[N];

        list.add(Integer.MIN_VALUE);
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            int n = Integer.parseInt(st.nextToken());
            arr[i] = n;

            if (list.get(list.size() - 1) < n) {
                list.add(n);
                index[i] = list.size()-1;

            } else {
                int start = 0;
                int end = list.size()-1;
                while (start < end) {
                    int mid = (start + end) / 2;
                    if(list.get(mid) >= n) end = mid;
                    else start = mid+1;
                }
                list.set(end, n);
                index[i] = end;
            }
        }
        System.out.println(list.size() - 1);

        int idx = list.size() - 1;
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(int i=N-1; i>=0; i--){
            if(index[i] == idx){
                stack.push(arr[i]);
                idx--;
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }

        System.out.println(sb);
    }
}
