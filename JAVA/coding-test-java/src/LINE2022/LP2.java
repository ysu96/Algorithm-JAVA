package LINE2022;

import java.util.ArrayList;
import java.util.List;

public class LP2 {

    class Sentence {
        String s;
        int score;

        Sentence(String s, int score) {
            this.s = s;
            this.score = score;
        }
    }

    public int solution(String[] sentences, int n) {
        int answer = -1;
        //점수 크기 순으로 정렬? || 길어순으로 정렬?
        //점수 큰거 순으로 해보면서 점수 세기
        // 그 다음 점수??
        // 그리디 같은데

        //배열 길이 15
        // 원소 길이 10만
        List<Sentence> list = new ArrayList<>();
        // 일단 반복문으로 점수 구해놓기?
        for (String sentence : sentences) {
            int score = sentence.length();
            for (int i = 0; i < sentence.length(); i++) {
                if (sentence.charAt(i) >= 65 && sentence.charAt(i) <= 90) {
                    score++;
                }
            }
            list.add(new Sentence(sentence, score));
        }

        //최대 15번 가장 먼저 해결할 거 찾기??
        for (int i = 0; i < sentences.length; i++) {

        }

        return answer;
    }
}
