package JAVA.Programmers.src.KAKAO2022;

//24분 자료형 long 주의!
public class p3_k진수에서소수개수구하기 {
    public int solution(int n, int k) {
        int answer = 0;
        String s = dec2k(n, k);
        StringBuilder tmp = new StringBuilder();

        for(int i=0; i<s.length(); i++){
            if(Character.getNumericValue(s.charAt(i)) > 0){
                tmp.append(s.charAt(i));
            }else{
                if(tmp.length() != 0 && isPrime(Long.parseLong(tmp.toString()))){
                    answer++;
                }

                tmp = new StringBuilder();
            }
        }

        if (tmp.length() != 0 && isPrime(Long.parseLong(tmp.toString()))) {
            answer++;
        }

        return answer;
    }

    public String dec2k(int n, int k) {
        StringBuilder sb = new StringBuilder();
        int cur = n;
        while (cur > 0) {
            sb.append(cur % k);
            cur /= k;
        }
        return sb.reverse().toString();
    }

    public boolean isPrime(long n){
        if(n == 2) return true;
        if(n < 2) return false;
        for(long i = 2; i<= Math.sqrt(n); i++){
            if(n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        p3_k진수에서소수개수구하기 p3 = new p3_k진수에서소수개수구하기();
        System.out.println(p3.dec2k(1000000, 2));
//        System.out.println(p3.solution(110011, 10));
        System.out.println(p3.solution(1000000, 5));
    }
}
