package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1764 {
    public static int N,M;
    public static Map<String, Boolean> map = new HashMap<>();
    public static List<String> answer = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for(int i=0; i<N; i++){
            map.put(br.readLine(), true);
        }
        for(int i=0; i<M; i++){
            String tmp = br.readLine();
            if (map.containsKey(tmp)) {
                answer.add(tmp);
            }
        }
        System.out.println(answer.size());
        Collections.sort(answer);
        for (String s : answer) {
            System.out.println(s);
        }
    }
}
