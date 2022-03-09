package JAVA.Programmers.src.KAKAO2022;

import java.util.*;

public class p2_주차요금계산 {
    public int[] solution(int[] fees, String[] records) {
        HashMap<String, Integer> parking = new HashMap<>(); // 주차 시간 기록
        HashMap<String, String> history = new HashMap<>(); // 입차 시간 기록
        HashMap<String, Integer> totalFee = new HashMap<>();

        //TreeMap은 키 자동 오름차순 정렬 저장!!

        for (String record : records) {
            String[] str = record.split(" ");
            String time = str[0];
            String car = str[1];
            String status = str[2];

            if (status.equals("IN")) {
                if(!parking.containsKey(car)) parking.put(car, 0);
                parking.put(car, parking.getOrDefault(car, 0));
                history.put(car, time);
            }else{
                String start = history.get(car);
                int cal = calculate(start, time);
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

        for (String car : parking.keySet()) {
            int time = parking.get(car);
            int fee = 0;
            if(time <= fees[0]) fee = fees[1];
            else{
                time -= fees[0];
                if(time % fees[2] != 0) time = time/fees[2] + 1;
                else time = time/fees[2];
                fee = time * fees[3] + fees[1];
            }
            totalFee.put(car, fee);
        }

        int[] answer = new int[totalFee.keySet().size()];
        List<String> list = new ArrayList<>(totalFee.keySet());
        Collections.sort(list);
        for(int i=0; i<list.size(); i++){
            answer[i] = totalFee.get(list.get(i));
        }

        return answer;
    }

    public static int calculate(String t1, String t2){
        String hour1 = t1.substring(0,2);
        String minute1 = t1.substring(3);
        int time1 = (Integer.parseInt(hour1) * 60) + Integer.parseInt(minute1);

        String hour2 = t2.substring(0,2);
        String minute2 = t2.substring(3);
        int time2 = (Integer.parseInt(hour2) * 60) + Integer.parseInt(minute2);
        return time2 - time1;
    }
}
