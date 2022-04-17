package LINE2022;

public class LP4 {
    // 틀림
    // * 구간의 기둥을 바꾼다고 해도 인접한 2개의 구간의 총합이 달라지지 않는다 *
    // 누적합이 다르면 그 사이 기둥은 무~!조건 옮기게 되어있음!!

    //누적합 해서 idx별 누적합이 다르면 그 기둥을 바꿈 answer++
    //값이 같으면 횟수 안 더하기

    //다른 셀을 안 바꾸고 자기 위치를 맞추는 구간이 최소 1개는 있다

    //arr[3, 3, 6, 8]
    //brr[10, 1, 1, 8]
    // [3,10] -> [6, 11] -> [12,12] -> [20, 20]

    // arr[3, 7, 2, 4]
    // brr[4, 5, 5, 2]
    // [3, 4] -> [10, 9] -> [12, 14] -> [16,16]  : 3

    // arr[6, 2, 2, 6]
    // brr[4, 4, 4, 4]
    // [6, 4] -> [8, 8] -> [10, 12] -> [16, 16] : 2
    public int solution(int[] arr, int[] brr) {
        int answer = 0;
        boolean headStart = true;
        //원소가 4개인 경우만 생각해버렸네
        if(brr[0] - arr[0] >= arr[1]){
            headStart = false;
        }

        // [8, 1, 1, 8]
        /// [7, 2, 2, 7]
        // [2, 5, 1, 5]
        // [6, 1, 5, 1]

        // [8, 1, 1, 1]
        // [1. 1, 1, 8]

        // [7, 1, 10, 1,2]
        // [9, 1, 1, 7 ,3]
        // [7,9] -> [8,10] -> [18,11] -> [19,18] -> []
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
