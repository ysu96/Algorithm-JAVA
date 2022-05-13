package SSG;

import java.util.ArrayList;
import java.util.List;

public class SSG1 {
    //선두 교체 방식
    // v[] : 트럭 연료량, a : 선두 시간당 연료 소비량, b : 뒤쪽 시간당 연료 소비량
    // 최대 몇시간 운행 가능?

    // v 최대 100000
    // 1시간 단위 변경 가능
    // 하나라도 1시간 운행 연료량 안되면 종료
    // 1시간 마다 남은 연료 체크 - 가장 많이 남은애 선두로 변경?? -> 시간 초과


    // while에서
    // 1. 전체 b 씩 빼기, b 용량 없으면 끝
    // 2. 가장 많은 애 체크해서 a-b만큼 빼기

    // 3.

    // 차량별로 선두 몇번할 수 있는지?
    // 배열 / b 해서 최소값 가져오기 ( 4, 5, 5) : 4
    // a-b 구하기 (1) 1*4 + 4 = 8 , 8이 있어야 4번 돌 수 있다
    // 가장 큰 값은

    // 크기 순 정렬 [5, 5, 4]
    //

    public static int head; // 선두 인덱스
    public static int time; // 시간

    public int solution2(int[] v, int a, int b){
        time = 0;

        while(true){
            int idx = -1;
            int maxOil = -1;
            boolean head = false;

            // 선두 가능한지?, 가능한 차 없으면 끝
            for(int i=0; i<v.length; i++) {
                if(v[i] >= a){
                    head = true;
                    break;
                }
            }
            if(!head) break;

            // b 씩 다 빼고 최대 연료 인덱스 구하기
            // b도 모자라면 끝
            for(int i=0; i<v.length; i++) {
                if(b > v[i]) return time;
                v[i] -= b;

                if(maxOil < v[i]){
                    maxOil = v[i];
                    idx = i;
                }
            }
            v[idx] -= (a - b);

            time++;
        }
        return time;
    }

    public int solution(int[] v, int a, int b){
        time = 0;
        while(true){
            head = maxOilLeft(v, a, b);
            if(head == -1) break;

            for(int i=0; i<v.length; i++) {
                if(i == head){
                    v[i] -= a;
                }else{
                    v[i] -= b;
                }
            }
            time++;
        }
        System.out.println(time);
        return time;
    }

    // 연료 가장 많이 남은 인덱스 반환, -1 반환 시 더 이상 주행 불가능
    public static int maxOilLeft(int[] v, int a, int b){
        int oilLeft = 0, idx = 0;
        for (int i = 0; i < v.length; i++) {
            if(oilLeft < v[i]){
                oilLeft = v[i];
                idx = i;
            }

            // 더 이상 주행 불가능
            if(b > v[i]){
                return -1;
            }
        }

        boolean headPossible = false;
        for(int i=0; i<v.length; i++){
            if(a <= v[i]){
                headPossible = true;
                break;
            }
        }
        if(!headPossible) return -1; // 선두 가능한 차량 없음
        return idx;
    }


    public static void main(String[] args) {
        SSG1 ssg1 = new SSG1();
        System.out.println(ssg1.solution2(new int[]{4,4,3}, 2, 1));
    }
}
