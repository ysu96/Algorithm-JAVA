package 입단테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class problem1 {
    public static int T,N;
    public static List<Integer> arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int tt=0; tt<T; tt++){
            N = Integer.parseInt(br.readLine());
            arr = new ArrayList<>();
            int answer = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                arr.add(Integer.parseInt(st.nextToken()));
            }
            Collections.sort(arr);
            while(!arr.isEmpty()){
                int a = arr.get(arr.size()-1);
                arr.remove(arr.size()-1);
                boolean complete = false;
                for(int i=0; i<arr.size(); i++){
                    if((arr.get(i)+a)%2 == 0){
                        arr.remove(i);
                        answer+=a;
                        complete = true;
                        break;
                    }
                }
                if(!complete){
                    for(int i=arr.size()-1; i>=0; i--){
                        if((arr.get(i)+a)%2 == 1){
                            answer += arr.get(i);
                            arr.remove(i);
                            break;
                        }
                    }
                }
            }
            System.out.println("#"+(tt+1)+" "+answer);
        }
    }
}
