package 카카오개발자겨울인턴십_2019;

import java.util.Arrays;

//이진 탐색으로 풀어야 효율성 통과가능 !!!
public class 징검다리건너기 {
    public int solution(int[] stones, int k) {
        int answer = 0;
        int min = Arrays.stream(stones).min().getAsInt();
        int max = Arrays.stream(stones).max().getAsInt();

        while(min <= max){
            int mid = (max+min)/2;
            if(check(stones,mid,k)) {
                answer = Math.max(answer,mid);
                min = mid+1;
            }
            else{
                max = mid-1;
            }
        }
        return answer;
    }

    public boolean check(int[] stones, int mid, int k){
        int[] stones2 = stones.clone();


        int count = 1;
        for(int i=0; i<stones2.length; i++) {
            stones2[i] -= mid;
            stones2[i] += 1;
        }

        for(int i=0; i<stones2.length;i++){
            if(stones2[i] <= 0){
                if(i == stones2.length-1){
                    count++;
                    if(count <= k){
                        continue;
                    }
                    else{
                        return false;
                    }
                }
                else count++;
            }
            else{
                count = 1;
            }

            if(count > k) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        징검다리건너기 a = new 징검다리건너기();
        int[] aa = {3,3,3,3,3,3,3,3,3,3,3,4};
        System.out.println(a.solution(aa, 12));
    }
}
