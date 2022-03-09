package JAVA.Programmers.src.KAKAO2022;

import java.util.*;

public class p1_신고결과받기 {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        HashMap<String, Integer> idx = new HashMap<>();
        for (int i=0; i<id_list.length; i++) {
            idx.put(id_list[i], i);
        }

        HashMap<String, Set<String>> hm = new HashMap<>();
        for (String s : id_list) {
            hm.put(s, new HashSet<>());
        }

        for (String s : report) {
            String[] ss = s.split(" ");
            Set<String> tmp = hm.get(ss[1]);
            tmp.add(ss[0]);
            hm.put(ss[1], tmp);
        }

        for (String key : hm.keySet()) {
            if(hm.get(key).size() >= k){
                for (String id : hm.get(key)) {
                    answer[idx.get(id)]++;
                }
            }
        }
        return answer;
    }
}
