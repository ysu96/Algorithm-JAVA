package 카카오페이;

public class KP3 {
    public int solution(String line1, String line2){
        int answer = 0;
        int emp = 0; //공백 길이
//        int emp_n = 0; // 공백 총 길이
        int emp_len = line2.length(); // 공백 포함 길이
        String line3 = new String(line2);

        while(line3.length() <= line1.length()) {
//            System.out.println(line3);
            for (int i = 0; i <= line1.length() - emp_len; i++) {
                String tmp = line1.substring(i, i + emp_len);
                boolean check = true;

                for (int j = 0; j < tmp.length(); j += (emp + 1)) {
                    if (tmp.charAt(j) != line3.charAt(j)) {
                        check = false;
                    }
                }
                if (check) {
                    System.out.println(tmp);
                    answer++;
                }
            }

            emp++;
//            emp_n = (line2.length() - 1) * emp;
//            emp_len = line2.length() + emp_n;
            line3 = "";
            for (int k = 0; k < line2.length(); k++) {
                line3 += line2.charAt(k);
                if(k!=line2.length()-1){
                    for (int z = 0; z < emp; z++) {
                        line3 += "_";
                    }
                }
            }
            emp_len = line3.length();
        }
        return answer;
    }

    public static void main(String[] args) {
        KP3 k = new KP3();
        System.out.println(k.solution("abacaba", "aa"));
    }
}
