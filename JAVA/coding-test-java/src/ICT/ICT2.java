package ICT;

import java.util.ArrayList;
import java.util.List;

public class ICT2 {
    public static int getMinDeletions(String s){

        List<Character> arr = new ArrayList<>();
        int s_length = s.length();
        for(int i=0; i<s_length; i++){
            if(!arr.contains(s.charAt(i))){
                arr.add(s.charAt(i));
            }

        }
        return s_length-arr.size();
    }

}
