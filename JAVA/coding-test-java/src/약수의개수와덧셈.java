public class 약수의개수와덧셈 {
    public int solution(int left, int right) {
        int answer = 0;
        for(int i=left; i<= right; i++){
            if(check(i)%2 == 0){ //EVEN
                answer+=i;
            }
            else{ //ODD
                answer-=i;
            }
        }
        return answer;
    }

    //약수 개수 체크
    public int check(int num){
        int count = 0;
        for(int i=1; i<= num/2; i++){
            if(num%i == 0){
                count++;
            }
        }
        count++;
        return count;
    }
}
