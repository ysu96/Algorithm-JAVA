package ICT;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class ICT5 {
    public static String decode(List<String> codes, String encoded) {
        // Write your code here
        HashMap<String, Character> map = new LinkedHashMap<>();
        String tmp = "";
        String answer = "";
        for (String s : codes) {
            if(s.contains("newline")){
                map.put(s.substring(10),'\n');
            }
            else{
                map.put(s.substring(2),s.charAt(0));
            }
        }
        for(int i=0; i<encoded.length(); i++){
            tmp += encoded.charAt(i);
            if(map.containsKey(tmp)){
                answer+= map.get(tmp);
                tmp = "";
            }

        }
        return answer;

    }
}
