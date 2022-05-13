package SSG;

import java.util.*;

public class SSG2 {

    // 답안 제출 후 바로 채점

    // 푼 문제 수 동일 , 5 미만인 경우 제외
    // 푼 문제 번호가 모두 같음
    // 푼 문제의 점수가 모두 같음

    // 수험번호, 문제 번호, 받은 점수
    // 없으면 "None"

    class Grade{
        int id;
        Map<Integer, Integer> problems = new HashMap<>();
    }

    public static Grade[] grades = new Grade[10000];

    public String[] solution(String[] logs){
        for (String log : logs) {
            String[] split = log.split(" ");
            int id = Integer.parseInt(split[0]);
            int problemNo = Integer.parseInt(split[1]);
            int score = Integer.parseInt(split[2]);

            if (grades[id] == null) {
                grades[id] = new Grade();
            }

            grades[id].problems.put(problemNo, score);
        }

        boolean[] cheating = new boolean[10000];
        for(int i = 0; i < 10000; i++){
            if(grades[i] == null) continue;

            for(int j = i+1; j < 10000; j++){
                if(grades[j] == null) continue;
                if (isCheating(grades[i], grades[j])) {
                    cheating[i] = true;
                    cheating[j] = true;
                }
            }
        }

        List<String> answer = new ArrayList<>();
        for(int i = 0; i < 10000; i++){
            if(cheating[i]){
                answer.add(parseString(i));
            }
        }


        return answer.toArray(new String[answer.size()]);
    }

    public static String parseString(int n){
        StringBuilder sb = new StringBuilder();
        String num = Integer.toString(n);
        for(int i=0; i< 4-num.length(); i++){
            sb.append("0");
        }
        sb.append(num);
        return sb.toString();
    }

    public static boolean isCheating(Grade a, Grade b){
        Map<Integer, Integer> PA = a.problems;
        Map<Integer, Integer> PB = b.problems;

        if (PA.size() == PB.size() && PA.size() >= 5) {
            if(PA.keySet().containsAll(PB.keySet())){
                int cnt = 0;
                for(int no : PA.keySet()){
                    if(PA.get(no).equals(PB.get(no))) cnt++;
                }
                return cnt == PA.size();
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SSG2 ssg2 = new SSG2();
        System.out.println(Integer.parseInt("0001"));
//        System.out.println(ssg2.solution());
    }
}
