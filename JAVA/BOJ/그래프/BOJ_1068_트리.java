package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1068_트리 {
    public static int n;
    public static int[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        tree = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            int num = Integer.parseInt(st.nextToken());
            tree[i] = num;
        }

        int remove = Integer.parseInt(br.readLine());
        tree[remove] = -2;
        dfs(remove);
        int ans = 0;
        //leaf node count
        for(int i=0; i<n; i++){
            boolean check = true;
            if(tree[i] == -2) continue;
            for(int j=0; j<n; j++){
                if(tree[j] == i){
                    check = false;
                    break;
                }
            }
            if(check) ans++;
        }
        System.out.println(ans);
    }
    public static void dfs(int remove){
        for(int i=0; i<n; i++){
            if(tree[i] == remove){
                tree[i] = -2;
                dfs(i);
            }
        }
    }
}
