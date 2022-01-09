package 카카오뱅크;

import java.util.*;

public class P2 {
    public long solution(String[] arr1, String[] arr2) {
        long answer = 0;
        List<String> Oarr1 = new ArrayList<>(); // arr1 중 올바른 괄호
        List<String> Oarr2 = new ArrayList<>(); // arr2 중 올바른 괄호
        List<String> Xarr1 = new ArrayList<>(); // arr1 중 틀린 괄호
        List<String> Xarr2 = new ArrayList<>(); // arr2 중 틀린 괄호
        Map<String, Long> map = new HashMap<>();

        for (String s : arr1) {
            if (check(s)) Oarr1.add(s);
            else Xarr1.add(s);
        }

        for (String s : arr2) {
            if (check(s)) Oarr2.add(s);
            else Xarr2.add(s);
        }

        // 올바른 괄호끼리 더하면 항상 올바른 괄호가 됨
        // Oarr1 개수 * Oarr2 개수
        answer += ((long) Oarr1.size() * Oarr2.size());

        for (String s1 : Xarr1) {
            // 중복 문자를 대비해 map에 기록하면서 시간 단축
            if (map.containsKey(s1)) answer += map.get(s1);
            else {
                long cnt = 0;
                for (String s2 : Xarr2) {
                    if (check(s1 + s2)) cnt++;
                }
                map.put(s1, cnt);
                answer += cnt;
            }
        }

        return answer;
    }

    //올바른 괄호인지 체크
    public boolean check(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') stack.push(c);
            else if (stack.empty()) return false;
            else stack.pop();
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        P2 p2 = new P2();
        p2.solution(new String[]{"()", "(()", "(", "(())"}, new String[]{")()", "()", "(())", ")()"});
    }
}
