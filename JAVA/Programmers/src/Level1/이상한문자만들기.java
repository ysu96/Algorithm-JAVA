package JAVA.Programmers.src.Level1;

import java.util.Locale;

public class 이상한문자만들기 {
    public String solution(String s) {
        String answer = "";
        s = s.toLowerCase(Locale.ROOT);
        int idx = 0;
        for(int i=0; i<s.length(); i++){
            if (s.charAt(i) == ' ') {
                answer += ' ';
                idx = 0;
                continue;
            }

            if (idx % 2 == 0) {
                answer += (char)(s.charAt(i) - 32);
            }else{
                answer += s.charAt(i);
            }
            idx++;
        }
        return answer;
    }
}
