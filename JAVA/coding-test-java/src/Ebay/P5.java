package Ebay;

import java.util.*;

public class P5 {
    public static Set<String> set = new HashSet<>();
    public static String tmp;
    public String[] solution(String []P) {
        String[] answer = new String[2];
        List<String> ans = new LinkedList<>();
        List<String> strings = Arrays.asList(P);
        tmp = P[0];
        for(int i=0; i<P.length; i++){
            String first = P[i];
            for(int j=i+1; j<P.length; j++){
                String second = P[j];
                String sumStr1 = first+second;
                if(check(sumStr1)){
                    P[i] = "-";
                    P[j] = "-";
                    break;
                }
                String sumStr2 = second+first;
            }
        }
        return answer;
    }
    public static void back(List<String> P){
        for(int i=0; i<P.size(); i++){
            String first = P.get(i);
            for(int j=i+1; j<P.size(); j++){
                String second = P.get(j);
                String sumStr1 = first+second;
                String sumStr2 = second+first;
                if(check(sumStr1) || check(sumStr2)){
                    if (i == 0 && first.equals(tmp)) {
                        set.add(second);
                    }
                    P.remove(i);
                    P.remove(j);
                    back(P);
                }
            }
        }
    }
    public static boolean check(String s){
        for(int i=0; i<(int)(s.length()/2); i++){
            if(s.charAt(i) != s.charAt(s.length()-i-1)) return false;
        }
        return true;
    }
}
