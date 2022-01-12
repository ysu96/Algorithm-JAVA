package NTS2022;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution3 {
    public int solution(String join_date, String resign_date, String[] holidays) {
        Map<String, Integer> days = new HashMap<>();
        days.put("MON", 0);
        days.put("TUE", 1);
        days.put("WED", 2);
        days.put("THU", 3);
        days.put("FRI", 4);
        days.put("SAT", 5);
        days.put("SUN", 6);
        int day = days.get(join_date.substring(11));
        int[] today = parsing_YMD(join_date, day);
        int[] resign_day = parsing_YMD(resign_date, -1);
        int answer = 0;

        while (true) {
            System.out.println(Arrays.toString(today));
            if (is_workingDay(today) && !is_holiday(today, holidays)) {
                answer++;
            }
            if (is_resignDay(today, resign_day)) {
                break;
            }
            today = tomorrow(today);
        }
        System.out.println(answer);
        return answer;
    }

    public static void main(String[] args) {
        Solution3 s3 = new Solution3();
        s3.solution("2019/12/01 SUN", "2019/12/31", new String[]{"12/25"});
    }

    public boolean is_resignDay(int[] today, int[] resign_day) {
        if (today[0] == resign_day[0] && today[1] == resign_day[1] && today[2] == resign_day[2]) {
            return true;
        }
        return false;
    }

    public int[] parsing_YMD(String date, int day) {
        int[] tmp = new int[4];
        tmp[0] = Integer.parseInt(date.substring(0, 4));
        tmp[1] = Integer.parseInt(date.substring(5, 7));
        tmp[2] = Integer.parseInt(date.substring(8, 10));
        tmp[3] = day;
        return tmp;
    }

    public boolean checkYun(int year) {
        if (year % 400 == 0) return true;
        if (year % 100 == 0) return false;
        return year % 4 == 0;
    }

    public boolean is_workingDay(int[] day) {
        int DD = day[3];
        if (DD == 5 || DD == 6) {
            return false;
        }
        return true;
    }

    public int[] tomorrow(int[] today) {
        int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int Y = today[0];
        int M = today[1];
        int D = today[2];
        int DD = today[3];
        int last = days[M];
        if (checkYun(Y) && M == 2) {
            last++;
        }

        if (D == last) {
            D = 1;
            M++;
        } else {
            D++;
        }
        if (M == 13) {
            M = 1;
            Y++;
        }
        return new int[]{Y, M, D, (DD + 1) % 7};
    }

    public boolean is_holiday(int[] today, String[] holidays) {
        for (String s : holidays) {
            if (s.equals(Integer.toString(today[1]) + '/' + today[2])) {
                return true;
            }
        }
        return false;
    }

}
