public class 삼진법뒤집기 {
    public int solution(int n) {
        String answer = "";
        //3진법 변환 , reverse
        while(n>0){
            answer = answer + (n%3);
            n = n/3;
        }
        int ans = Integer.parseInt(answer, 3);
        return ans;
    }
}
