package 카카오인턴십_2020;

import java.util.*;

public class 보석쇼핑 {
    public int[] solution(String[] gems) {
        int[] answer = {};
        int n = gems.length;
        int startpoint = 0;
        int start= 0;
        int min_length = (int)1e9;
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        Queue<String> q = new LinkedList<String>();
        HashSet<String> hs = new HashSet<String>();
        hs.addAll(Arrays.asList(gems));

        for(int i =0; i< n ;i++){
            if(hm.containsKey(gems[i])) hm.put(gems[i], hm.get(gems[i])+1);
            else hm.put(gems[i], 1);

            q.add(gems[i]);

            while(true){
                String tmp = q.peek();

                //이미 뒤쪽에 해당 보석을 포함하는 경우 시작점을 올린다
                if(hm.get(tmp) > 1){
                    hm.put(tmp, hm.get(tmp)-1);
                    q.poll();
                    startpoint++;
                }
                else{
                    break;
                }
            }

            if(hm.size() == hs.size() && min_length > q.size()){
                min_length = q.size();
                start = startpoint;
            }

        }
        answer = new int[]{start+1, start+min_length};

        return answer;
    }

    public static void main(String[] args) {
        보석쇼핑 a = new 보석쇼핑();
        String[] ss = {"A", "B", "C", "B", "F", "D", "A", "F", "B", "D", "B"};
        System.out.println(a.solution(ss)[0]);
        System.out.println(a.solution(ss)[1]);
    }
}
