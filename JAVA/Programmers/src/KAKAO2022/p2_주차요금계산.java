package JAVA.Programmers.src.KAKAO2022;

import java.util.*;

//26분걸림
public class p2_주차요금계산 {
    public int[] solution(int[] fees, String[] records) {
        //TreeMap은 키 자동 오름차순 정렬 저장!!
        TreeMap<String, Integer> parking = new TreeMap<>(); // 주차 시간 기록
        HashMap<String, String> history = new HashMap<>(); // 입차 시간 기록

        for (String record : records) {
            String[] str = record.split(" ");
            String time = str[0];
            String car = str[1];
            String status = str[2];

            if (status.equals("IN")) {
                parking.put(car, parking.getOrDefault(car, 0));
                history.put(car, time);
            } else {
                int cal = calculate(history.get(car), time);
                parking.put(car, parking.get(car) + cal); //주차 시간 더하기
                history.put(car, null);
            }
        }

        for (String car : history.keySet()) {
            if (history.get(car) != null) {
                int cal = calculate(history.get(car), "23:59");
                parking.put(car, parking.get(car) + cal); //주차 시간 더하기
            }
        }

        int[] answer = new int[parking.keySet().size()];
        int idx = 0;

        for (int time : parking.values()) {
            int fee = fees[1];
            time -= fees[0];
            if (time > 0) {
                fee += (time % fees[2] == 0 ? time / fees[2] : time / fees[2] + 1) * fees[3];
            }
            answer[idx++] = fee;
        }

        return answer;
    }

    public static int calculate(String t1, String t2) {
        String hour1 = t1.substring(0, 2);
        String minute1 = t1.substring(3);
        int time1 = (Integer.parseInt(hour1) * 60) + Integer.parseInt(minute1);

        String hour2 = t2.substring(0, 2);
        String minute2 = t2.substring(3);
        int time2 = (Integer.parseInt(hour2) * 60) + Integer.parseInt(minute2);
        return time2 - time1;
    }
}
