package LINE2022;

import java.util.regex.Pattern;

public class LP1 {
    public int solution(String[] logs) {
        int answer = 0;
        //"team_name : t application_name : a error_level : e message : m"
        // 길이 100
        // 공백 x
        for(String log : logs){
            boolean flag = true;
            int len = log.length();

            String[] split = log.split(" ");
            // 0 : team_name
            // 1 : ":"
            // 2 : t
            // 3 : application_name
            // 4 : :
            // 5 : a
            // 6 : error_level
            // 7 : :
            // 8 : e
            // 9 : message
            // 10 : :
            // 11 : m

            if(len > 100) flag = false;
            else if(split.length != 12) flag = false;
            else if(!split[0].equals("team_name")) flag = false;
            else if(!split[3].equals("application_name")) flag = false;
            else if(!split[6].equals("error_level")) flag = false;
            else if(!split[9].equals("message")) flag = false;
            else if(!split[1].equals(":") || !split[4].equals(":") || !split[7].equals(":") || !split[10].equals(":")) flag = false;
            else if(!isAlpha(split[2]) || !isAlpha(split[5]) || !isAlpha(split[8]) || !isAlpha(split[11])) flag = false;

            if(!flag){
                answer++;
            }
        }
        return answer;
    }

    public static boolean isAlpha(String word) {
        return Pattern.matches("^[a-zA-Z]*$", word);
    }

}
