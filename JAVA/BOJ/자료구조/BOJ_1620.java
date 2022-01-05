package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_1620 {
    public static int N,M;
    public static Map<String, Integer> nameMap = new HashMap<>();
    public static Map<Integer, String> numMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        String name,quiz;
        for(int i=1; i<=N; i++){
            name = br.readLine();
            nameMap.put(name, i);
            numMap.put(i, name);
        }

        for(int i=0; i<M; i++){
            quiz = br.readLine();
            boolean isNumeric = quiz.chars().allMatch(Character::isDigit);
            if(isNumeric) System.out.println(numMap.get(Integer.parseInt(quiz)));
            else System.out.println(nameMap.get(quiz));
        }
    }
}
