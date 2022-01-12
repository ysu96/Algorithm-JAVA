package JAVA.LeetCode;

public class Leetcode7_ReverseInteger {
    public int reverse(int x) {
        StringBuilder sb = new StringBuilder();
        int answer = 0;

        if(x < 0) {
            String s = Integer.toString(x);
            s = s.substring(1);
            for(int i=s.length()-1; i>=0; i--){
                sb.append(s.charAt(i));
            }
            long y = Long.parseLong(sb.toString()) * -1;
            if (check(y)) {
                answer = (int) y;
            }

        }else{
            String s = Integer.toString(x);
            for(int i=s.length()-1; i>=0; i--){
                sb.append(s.charAt(i));
            }
            long y = Long.parseLong(sb.toString());
            if (check(y)) {
                answer = (int) y;
            }
        }
        return answer;
    }

    public boolean check(long x){
        if(x > Math.pow(2,31)-1 || x< Math.pow(2,31) * -1){
            return false;
        }
        return true;
    }
}
