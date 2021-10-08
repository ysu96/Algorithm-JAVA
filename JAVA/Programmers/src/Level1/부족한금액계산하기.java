package Level1;

public class 부족한금액계산하기 {
    public long solution(int price, int money, int count) {
        long answer = 0;
        long total = 0;
        for(int i=1; i<=count; i++){
            total+= (long) price *i;
        }
        answer = total-money;
        return (answer<0)? 0:answer;
    }

    public static void main(String[] args) {
        부족한금액계산하기 a = new 부족한금액계산하기();
        System.out.println(a.solution(3,200,4));

    }
}
