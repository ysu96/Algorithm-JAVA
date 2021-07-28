package 네이버웹툰;
import java.util.*;
public class third {
    public int solution(String s, String t) {
        int result = 0;
        int l = t.length();
        while(s.contains(t)){
            int idx = s.indexOf(t);
            s = s.substring(0,idx) + s.substring(idx+l);
            result++;
//            System.out.println("s = " + s);
        }
        return result;
    }

    public static void main(String[] args) {
        third a = new third();
        StringBuilder ss = new StringBuilder();
        for(int i =0; i<1000000; i++){
            ss.append("a");
        }
        String s ="";
        String t ="a";
        System.out.println(a.solution(ss.toString(),t));
    }
}
