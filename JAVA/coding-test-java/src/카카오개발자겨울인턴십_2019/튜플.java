package 카카오개발자겨울인턴십_2019;

import java.util.*;

public class 튜플 {
    public ArrayList<Integer> solution(String s) {
        ArrayList<Integer> answer = new ArrayList<>();
        ArrayList<Integer> al = new ArrayList<>();

        StringBuilder sb = new StringBuilder();

        boolean check = false;
        int num = 0;
        PriorityQueue<ArrayList<Integer>> pq = new PriorityQueue<>(new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> t1, ArrayList<Integer> t2) {
                return t1.size() - t2.size();
            }
        });

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '{'){

            }
            else if(s.charAt(i) == '}'){
                if(i==s.length()-1) break;

                check = true;
                num = Integer.parseInt(sb.toString());
                sb = new StringBuilder();
                al.add(num);

                pq.add(al);

                al = new ArrayList<>();
            }

            else if(Character.isDigit(s.charAt(i))){

                sb.append(s.charAt(i));

            }

            else if(s.charAt(i) == ','){
                if(check==true){
                    check= false;
                    continue;
                }
                num = Integer.parseInt(sb.toString());
                al.add(num);

                sb = new StringBuilder();
            }
        }

        System.out.println(pq.size());
        int len = pq.size();
        for(int i=0; i<len; i++){ //max 500
            ArrayList<Integer> tmp = pq.poll();

            for(int j=0;j<answer.size(); j++){
                tmp.remove(answer.get(j));
            }
            answer.add(tmp.get(0));

        }

        System.out.print("answer : ");
        for(int i : answer){

            System.out.print(i+" ");
        }
        return answer;
    }

    public static void main(String[] args) {
        튜플 a = new 튜플();
        a.solution("{{2},{2,1},{2,1,3},{2,1,3,4}}");
    }
}
