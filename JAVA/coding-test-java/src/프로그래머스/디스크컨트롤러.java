package 프로그래머스;

import java.util.*;

public class 디스크컨트롤러 {
    public int solution(int[][] jobs) {
        int answer = 0;
        int count = 0; //현재까지 처리한 요청
        int cur_time = 0; //현재 시간
        int idx = 0; //배열 인덱스

        Arrays.sort(jobs, (o1,o2) -> o1[0]-o2[0]); //요청 시간 순으로 오름차순 정렬
        PriorityQueue<int[]> candidates = new PriorityQueue<>((o1,o2) -> o1[1]-o2[1]); //소요 시간 오름차순으로 후보 정렬

        while (count < jobs.length) {
            //작업 처리 중에 들어오는 요청을 후보 큐에 추가
            while(idx < jobs.length && jobs[idx][0] <= cur_time){
                candidates.add(jobs[idx]);
                idx++;
            }

            //큐가 비어있으면 그 다음 요청 시간을 현재 시간으로 변경
            if(candidates.isEmpty()){
                cur_time = jobs[idx][0];
            }
            else{
                //후보들 중 소요 시간이 제일 적은 것 빼와서 정답에 추가
                int[] tmp = candidates.poll();
                answer += (cur_time+tmp[1] - tmp[0]);
                count++; //요청 처리

                // 처리한 요청이 끝나는 시간으로 현재시간 변경
                cur_time += tmp[1];
            }
        }

        return answer/jobs.length;
    }
}
