package 라인스튜디오인턴;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Line1 {
    public static boolean[] alpha = new boolean[26];

    public String solution(String source) {
        List<Character> dest = new LinkedList<>();

        while (true) {
            if (source.equals("")){
                StringBuilder sb = new StringBuilder();
                for (char s : dest) sb.append(s);
                System.out.println(sb.toString());
                return sb.toString();
            }

            String source2 = "";
            List<Character> destTmp = new LinkedList<>();
            for(int i=0; i<source.length(); i++){
//                System.out.println(source.charAt(i)-'a');
                if(!alpha[source.charAt(i)-'a']){
                    alpha[source.charAt(i)-'a'] = true;
                    destTmp.add(source.charAt(i));
                }else{
                    source2+=source.charAt(i);
                }
            }
            alpha = new boolean[26];
            source = source2;
            Collections.sort(destTmp);
            dest.addAll(destTmp);
//            for(int k =0; k<dest.size(); k++){
//                System.out.println(dest.get(k));
//            }
        }
    }

    public static void main(String[] args) {
        Line1 l1 = new Line1();
        l1.solution("ccccccaaaaa");
    }
}
