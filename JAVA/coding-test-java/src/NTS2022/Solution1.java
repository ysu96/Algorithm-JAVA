package NTS2022;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Customer implements Comparable<Customer> {
    int start;
    int end;
    Customer(int s, int e){
        this.start = s;
        this.end = e;
    }
    @Override
    public int compareTo(Customer a){
        if (this.start == a.start) {
            return this.end - a.end;
        }
        return this.start - a.start;
    }
}

public class Solution1 {
    public int solution(int[][] customer){
        List<Customer> list = new ArrayList<>();
        for (int[] c : customer) {
            list.add(new Customer(c[0], c[1]));
        }
        Collections.sort(list);
        int answer = list.get(0).end - list.get(0).start;
        int time = list.get(0).end;

        for(int i=1; i<list.size(); i++){
            if (list.get(i).start > time) {
                time = list.get(i).end;
                answer += (time - list.get(i).start);
            }else{
                if (time < list.get(i).end) {
                    answer += (list.get(i).end - time);
                    time = list.get(i).end;
                }else{
                    continue;
                }
            }
        }
        return answer;
    }
}
