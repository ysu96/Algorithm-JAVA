package SCPC;

import javax.swing.plaf.basic.BasicButtonUI;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

/*
   As the name of the class should be Solution , using Solution.java as the filename is recommended.
   In any case, you can execute your program by running 'java Solution' command.
 */
public class SCPC2 {
    static int Answer,n,t;
    static char[] arr,ans;
    static Set<Character>[] arr2;

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
        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        for(int test_case = 0; test_case < T; test_case++) {

            // Answer = 0;
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());
            arr = new char[n+1];
            ans = new char[n+1];
            arr2 = new HashSet[n+1];
            boolean[] check = new boolean[n + 1];
            st = new StringTokenizer(br.readLine());
            String tmp = st.nextToken();

            for(int i=0;i<n;i++){
                arr[i+1] = tmp.charAt(i);
                arr2[i+1] = new HashSet<Character>();
                ans[i+1] = '0';
            }


            for(int i=1;i<=n;i++){
                if(i>t && i<=n-t){
                    if(arr[i]=='1'){
                        if(check[i+t]){
                            if(ans[i+t] == '1') continue;
                        }
                        if(check[i-t]){
                            if(ans[i-t] == '1') continue;
                        }
                        arr2[i+t].add('1');
                        arr2[i-t].add('1');
//                        ans[i+t] = '1';
                    }
                    else{
                        if(check[i-t]){
                            continue;
                        }
                        arr2[i+t].add('0');
                        arr2[i - t].add('0');
                    }
                }

                else if(i<=n-t){
                    check[i+t] = true;
                    if(arr[i] == '1'){
                        ans[i+t] = '1';
                    }

                }
                else if (i>t){
                    check[i-t] = true;
                    if(arr[i] == '1'){
                        ans[i-t] = '1';
                    }

                }
            }

//            for(int i=1;i<=n;i++){
//                if(arr2[i].contains('0')){
//                    ans[i-1] = '0';
//                }
//                else{
//                    ans[i-1] = '1';
//                }
//                System.out.print(ans[i-1]);
//            }
//            for(int i=1;i<=n;i++){
//                System.out.print(ans[i]);
//            }
            char[] abc = new char[n];
            for(int i=1;i<=n;i++){
                if(check[i]) abc[i-1] = ans[i];
                else{
                    if(arr2[i].contains('0')) abc[i-1] = '0';
                    else abc[i-1] = '1';
                }
            }
            for(int i=0;i<n;i++){
                System.out.print(abc[i]);
            }
            String aa = abc.toString();
//            System.out.println(aa);
            // Print the answer to standard output(screen).
            System.out.println("Case #"+(test_case+1));
            System.out.println(Answer);
        }
    }
}