package JAVA.Programmers.src.level2;

import java.util.HashSet;
import java.util.Set;

public class 영어끝말잇기 {
    public static int[] solution(int n, String[] words) {
        int[] answer = {0, 0};
        char lastChar = words[0].charAt(words[0].length() - 1);
        char startChar;
        Set<String> log = new HashSet<>();
        log.add(words[0]);

        for(int i = 1; i < words.length; i++) {
            String word = words[i];
            startChar = word.charAt(0);
            log.add(word);
            // 규칙 실패
            if(startChar != lastChar || log.size() != i+1) {
                answer[0] = (i % n) + 1;
                answer[1] = (i / n) + 1;
                return answer;
            } else {
                lastChar = word.charAt(word.length() - 1);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] s = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
        int[] a = solution(3, s);
        System.out.println(a[0]);
        System.out.println(a[1]);

    }
}
