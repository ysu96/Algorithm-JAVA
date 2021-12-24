package 네이버ETECH;

import java.util.HashSet;
import java.util.Set;

class Tree {
    public int x;
    public Tree l;
    public Tree r;
}

public class Task2 {
    public static int answer;
    public static Set<Integer> set = new HashSet<>();
    public int solution(Tree T) {
        // write your code in Java SE 8
        if(set.contains(T.x)) {
            answer = Math.max(answer, set.size());
            return answer;
        }

        set.add(T.x);

        if(T.l != null) solution(T.l);
        else answer = Math.max(answer, set.size());

        if(T.r != null) solution(T.r);
        else answer = Math.max(answer, set.size());

        set.remove(T.x);
        return answer;
    }

}
