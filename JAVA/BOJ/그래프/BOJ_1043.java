package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

//거짓말
public class BOJ_1043 {
    public static int N, M, T;
    public static boolean[] people; // 0 : 무지, 1 : 진실, 2 : 거짓
    public static List<Integer>[] party;
    public static int answer;
    public static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        people = new boolean[N + 1];

        parent = new int[N + 1];
        for(int i=1; i<=N; i++) parent[i] = i;

        party = new List[M];
        for (int i = 0; i < M; i++) {
            party[i] = new LinkedList<>();
        }

        st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= T; i++) {
            people[Integer.parseInt(st.nextToken())] = true;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());

            if(num <= 1){
                party[i].add(Integer.parseInt(st.nextToken()));
                continue;
            }

            int first = Integer.parseInt(st.nextToken());
            party[i].add(first);
            for (int j = 1; j < num; j++) {
                int a = Integer.parseInt(st.nextToken());
                union(first, a);
                party[i].add(a);
            }
        }

        for(int i=1; i<=N; i++){
            if(people[i]){
                int root = find_parent(i);
                for(int j=1; j<=N; j++){
                    if (find_parent(j) == root) {
                        people[j] = true;
                    }
                }
            }
        }

        for(int i=0; i<M; i++){
            boolean check = false;
            for(int p : party[i]){
                if(people[p]){
                    check = true;
                    break;
                }
            }
            if(!check) answer++;
        }
        System.out.println(answer);
    }

    public static int find_parent(int x){
        if (x != parent[x]) {
            return parent[x] = find_parent(parent[x]);
        }
        return parent[x];
    }

    public static void union(int a, int b) {
        int parent_a = find_parent(a);
        int parent_b = find_parent(b);
        parent[parent_b] = parent_a;
    }
}
