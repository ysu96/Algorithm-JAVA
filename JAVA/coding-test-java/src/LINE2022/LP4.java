package LINE2022;

public class LP4 {
    public int solution(int[] arr, int[] brr) {
        int answer = 0;
        boolean headStart = true;
        if(brr[0] - arr[0] >= arr[1]){
            headStart = false;
        }

        if(headStart){
            for(int i=0; i<arr.length-1; i++){
                if(arr[i] == brr[i]) continue;
                int n = brr[i] - arr[i];
                arr[i]+=n;
                arr[i+1]-=n;
                answer++;
            }
        }else{
            for(int i=arr.length-1; i>0; i--){
                if(arr[i] == brr[i]) continue;
                int n = brr[i] - arr[i];
                arr[i]+=n;
                arr[i-1]-=n;
                answer++;
            }
        }

        return answer;
    }
}
