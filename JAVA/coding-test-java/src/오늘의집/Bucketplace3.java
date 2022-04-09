package 오늘의집;

import java.util.HashMap;

public class Bucketplace3 {
    public String solution(String tstring, String[][] variables) {
        HashMap<String, String> map = new HashMap<>();
        HashMap<String, Boolean> history = new HashMap<>();
        String answer = new String(tstring);

        for (String[] variable : variables) {
            map.put(variable[0], variable[1]);
        }
        history.put(tstring, true);

        while (true) {
            StringBuilder tmp = new StringBuilder(); //new answer
            StringBuilder var = new StringBuilder(); //variable
            boolean isVariable = false;
            int varCnt = 0; // 대입할 수 있는 변수 카운트

            for (int i = 0; i < answer.length(); i++) {
                char c = answer.charAt(i);

                if (c == '{') {
                    isVariable = true;
                } else if (c == '}') {
                    isVariable = false;
                    String v = var.toString();
                    var = new StringBuilder();

                    if(map.containsKey(v)){
                        tmp.append(map.get(v));
                        varCnt++;
                    }else{
                        tmp.append('{').append(v).append('}');
                    }
                } else {
                    if (isVariable) var.append(c);
                    else tmp.append(c);
                }
            }

            //더 이상 대입할 변수가 없을 때 종료
            if(varCnt == 0) break;

            answer = tmp.toString();
            System.out.println(answer);

            // 이전 기록이 반복되면 종료
            if (history.containsKey(answer)) break;
            history.put(answer, true);
        }

        return answer;
    }
//
//    public boolean isVariableLeft(String tstring) {
//        for (int i = 0; i < tstring.length(); i++) {
//            if (tstring.charAt(i) == '{') {
//                return true;
//            }
//        }
//        return false;
//    }

    public static void main(String[] args) {
        Bucketplace3 bc3 = new Bucketplace3();
        String[][] variables = new String[][]{
                {"b", "{c}"}, {"a", "{b}"}, {"e", "{f}"}, {"h", "i"}, {"d", "{e}"}, {"f", "{d}"}, {"c", "d"}
        };
        System.out.println(bc3.solution("{a} {b} {c} {d} {i}", variables));
    }
}
