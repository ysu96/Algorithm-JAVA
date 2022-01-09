package 카카오뱅크;

import java.util.HashMap;
import java.util.Map;

public class P3 {
    public static boolean[] timeline;
    public static Map<String, Integer> days = new HashMap<>();
    public static int answer;

    public int solution(String[][] schedule) {
        timeline = new boolean[24 * 2 * 5];
        days.put("MO", 0);
        days.put("TU", 24);
        days.put("WE", 48);
        days.put("TH", 72);
        days.put("FR", 96);
        dfs(schedule, 0);
        return answer;
    }

    public static void dfs(String[][] schedule, int idx) {
        // 수업 5개 들었을 때
        if (idx == 5) {
            answer++;
            return;
        }
        // 4개 분반
        for (int i = 0; i < 4; i++) {
            String tmp = schedule[idx][i];
            //3시간 수업일 때
            if (tmp.length() <= 8) {
                //30분 단위로 잰 시간
                int time = getTime(tmp);

                //시간이 겹치면 다음 분반으로, 3시간 = 30분 * 6
                if (!check(6, time)) continue;

                //타임라인 체크
                for (int k = time; k < time + 6; k++) timeline[k] = true;

                //다음 과목으로
                dfs(schedule, idx + 1);

                //타임라인 체크 해제
                for (int k = time; k < time + 6; k++) timeline[k] = false;
            }
            //1시간 반 수업 2번
            else {
                String first = tmp.substring(0, 8);
                String second = tmp.substring(9);

                int time1 = getTime(first);
                int time2 = getTime(second);

                if (!check(3, time1) || !check(3, time2)) continue;

                for (int k = time1; k < time1 + 3; k++) timeline[k] = true;
                for (int k = time2; k < time2 + 3; k++) timeline[k] = true;

                dfs(schedule, idx + 1);

                for (int k = time1; k < time1 + 3; k++) timeline[k] = false;
                for (int k = time2; k < time2 + 3; k++) timeline[k] = false;
            }
        }
    }

    public static int getTime(String s) {
        String day = s.substring(0, 2);
        //30분 단위로 일주일을 나눔
        int hour = Integer.parseInt(s.substring(3, 5));
        int minute = s.substring(6, 8).equals("30") ? 1 : 0;
        return (days.get(day) + hour) * 2 + minute;
    }

    public static boolean check(int t, int time) {
        for (int k = time; k < time + t; k++) {
            if (timeline[k]) {
                return false;
            }
        }
        return true;
    }
}
