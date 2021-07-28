package 카카오페이;

public class KP1 {
    public int solution(int money, int minratio, int maxratio, int ranksize, int threshold, int months){
        int answer = -1;
        if(maxratio == 0) return money;

        int n_money = money - money%100; //소유가정금액
        int rest = money-n_money; //짤짤이

        if(money< threshold) return money;

        int n_ratio = ((n_money-threshold)/ranksize) + minratio;

        if(maxratio < n_ratio) n_ratio = maxratio;

        money = n_money*(100-n_ratio)/100 + rest;

        if(months==1){
            answer = money;
            return answer;
        }
        else{
            return solution(money,minratio,maxratio,ranksize,threshold,months-1);
        }
    }

    public static void main(String[] args) {
        KP1 k = new KP1();
        System.out.println(k.solution(1000000000,50,1,100000,0,6));
    }
}
