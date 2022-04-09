package 오늘의집;

import java.util.*;

public class Bucketplace2 {
    public String solution(String call) {
        HashMap<String, Integer> map = new HashMap<>();
        int len = 1;

        //패턴 등장 횟수 카운트
        while (len <= call.length()) {
            for (int i = 0; i < call.length() - len + 1; i++) {
                String s = call.substring(i, i + len).toLowerCase();
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
            len++;
        }

        int max = Collections.max(map.values());
        List<String> candidate = new ArrayList<>();

        for (String key : map.keySet()) {
            if (map.get(key) == max) {
                candidate.add(key);
            }
        }

        //제거 후보를 길이순으로 정렬
        Collections.sort(candidate, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        });

        //가장 긴 패턴부터 제거
        for(String s : candidate){
            if (call.toLowerCase().contains(s)) {
                call = replaceString(call, s);
            }
        }
        return call;
    }

    public String replaceString(String call, String s){
        String tmp = call.toLowerCase();
        int len = s.length();
        for(int i=0; i<tmp.length()-len+1; i++){
            if(tmp.substring(i, i+len).equals(s)){
                call = call.substring(0,i) + s + call.substring(i+len);
            }
        }

        return call.replace(s, "");
    }

    public static void main(String[] args) {
        Bucketplace2 bc2 = new Bucketplace2();
        System.out.println(bc2.solution("Aaabbabababcdcdcdcdcdcd"));
        //"abcabcdefabc"	"def"
        //"abxdeydeabz"	"xyz"
        //"abcabca"	"bcbc"
        //"ABCabcA"	"BCbc"
    }
}
