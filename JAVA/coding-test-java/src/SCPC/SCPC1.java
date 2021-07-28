package SCPC;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class SCPC1 {
    static int Answer;
    static int N;
    static int[] arr, parent;

    public static int find_parent(int x){
        if(parent[x] != x){
            parent[x] = find_parent(parent[x]);
        }
        return parent[x];
    }

    public static void union(int x, int y){
        x = find_parent(x);
        y = find_parent(y);
        if(x<y) parent[y] = x;
        else parent[x] = y;
    }

    public static void main(String args[]) throws Exception	{
		/*
		   The method below means that the program will read from input.txt, instead of standard(keyboard) input.
		   To test your program, you may save input data in input.txt file,
		   and call below method to read from the file when using nextInt() method.
		   You may remove the comment symbols(//) in the below statement and use it.
		   But before submission, you must remove the freopen function or rewrite comment symbols(//).
		 */

		/*
		   Make new scanner from standard input System.in, and read data.
		 */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //Scanner sc = new Scanner(new FileInputStream("input.txt"));
        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        for(int test_case = 0; test_case < T; test_case++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());

            arr = new int[N+1];
            parent = new int[N + 1];

            st = new StringTokenizer(br.readLine());
            for(int i=1; i<=N;i++){
                arr[i] = Integer.parseInt(st.nextToken());
                parent[i] = i;
            }

            for(int x=0;x<2;x++){
                for(int i=1;i<=N;i++){
                    if(arr[i]+i > N) continue;
                    union(i,arr[i]+i);
                }
            }

//            for(int i=1;i<=N;i++){
//                System.out.print(parent[i]+" ");
//            }

            Answer = 0;
            Set<Integer> s = new HashSet<>();
            for(int i=1; i<=N;i++){
                if(!s.contains(parent[i])){
                    Answer++;
                    s.add(parent[i]);
                }
            }


            // Print the answer to standard output(screen).
            System.out.println("Case #"+(test_case+1));
            System.out.println(Answer);
        }
    }
}
