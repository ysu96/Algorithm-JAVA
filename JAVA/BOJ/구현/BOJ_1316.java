package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_1316 {
    public static int answer;
    public static Map<Character, Boolean> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            boolean isAns = true;
            String s = br.readLine();
            char c = s.charAt(0);
            map.put(c, true);
            for(int j=1; j<s.length(); j++){
//                System.out.println(s.charAt(j));
                if(s.charAt(j) != c) {
                    if (map.containsKey(s.charAt(j))) {
                        isAns = false;
//                        System.out.println("------------");
                        break;
                    } else {
                        map.put(s.charAt(j), true);
                        c = s.charAt(j);
                    }
                }
            }
            if (isAns){
                answer++;
            }
            map.clear();

        }
        System.out.println(answer);

    }
}
