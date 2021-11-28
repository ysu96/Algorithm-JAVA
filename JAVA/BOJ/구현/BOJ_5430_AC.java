package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class BOJ_5430_AC {
    public static int T, n;
    public static String func, arrStr;
    public static ArrayDeque<Integer> arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            func = br.readLine();
            n = Integer.parseInt(br.readLine());
            arr = new ArrayDeque<>();
            boolean isRight = true;
            boolean isError = false;
            arrStr = br.readLine();
            arrStr = arrStr.substring(1, arrStr.length()-1);
            String[] split = arrStr.split(",");

            for(int i=0; i<n; i++){
                arr.add(Integer.parseInt(split[i]));
            }

            for(int i=0; i<func.length(); i++){
                if(func.charAt(i) == 'R'){
                    isRight = !isRight;
                }else{
                    if(arr.isEmpty()){
                        isError = true;
                        break;
                    }

                    if(isRight){
                        arr.removeFirst();
                    }else{
                        arr.removeLast();
                    }
                }
            }

            if(!isError){
                if(isRight){
                    StringBuilder sb = new StringBuilder();
                    sb.append('[');
                    if(arr.isEmpty()){

                    }
                    else{
                        sb.append(arr.pollFirst());
                        while(!arr.isEmpty()){
                            sb.append(',');
                            sb.append(arr.pollFirst());
                        }
                    }

                    sb.append(']');
                    System.out.println(sb.toString());
                }else{
                    StringBuilder sb = new StringBuilder();
                    sb.append('[');
                    if(arr.isEmpty()){

                    }
                    else{
                        sb.append(arr.pollLast());
                        while(!arr.isEmpty()){
                            sb.append(',');
                            sb.append(arr.pollLast());
                        }
                    }
                    sb.append(']');
                    System.out.println(sb.toString());
                }
            }
            else{
                System.out.println("error");
            }
        }
    }
}
