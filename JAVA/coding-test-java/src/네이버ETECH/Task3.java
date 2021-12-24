package 네이버ETECH;

import java.util.Arrays;

public class Task3 {
    public int solution(int[] A) {
        // write your code in Java SE 8
        Arrays.sort(A);
        int answer = 0;
        for(int i=0; i<A.length; i++){
            if(i+1 != A[i]){
                answer += Math.abs(A[i]-i-1);
            }
        }
        System.out.println(answer);
        return answer;
    }

    public static void main(String[] args) {
        Task3 t3 = new Task3();
        t3.solution(new int[]{4});
    }
}
