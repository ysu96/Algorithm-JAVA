import java.util.*;

public class 두개뽑아서더하기 {
    public int[] solution(int[] numbers) {
        int[] answer = {};
        Set<Integer> answer2 = new HashSet<>();
        for(int i=0; i<numbers.length-1; i++){
            for(int j=i+1; j<numbers.length; j++){
                answer2.add(numbers[i]+numbers[j]);
            }
        }
//        List<Integer> tmp = new ArrayList<>(answer2);
//        Collections.sort(tmp);
        answer = answer2.stream().sorted().mapToInt(Integer::intValue).toArray();

        return answer;
    }
}
