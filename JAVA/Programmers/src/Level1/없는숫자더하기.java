package Level1;

public class 없는숫자더하기 {
    public int solution(int[] numbers) {
        int answer = 0;
        for(int i=0; i<10; i++){
            for (int num : numbers) {
                if(num == i){
                    answer+=i;
                    break;
                }
            }
        }
        answer = 45-answer;
        return answer;
    }
}
