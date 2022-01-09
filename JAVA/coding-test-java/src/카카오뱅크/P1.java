package 카카오뱅크;

public class P1 {
    public int solution(int[][] fees, int usage) {
        int common = 0;
        int maxidx = 0;
        for (int i = 0; i < fees.length; i++) {
            // 마지막 인덱스
            if (i == fees.length - 1) {
                common = fees[i][1];
                maxidx = i;
                break;
            }

            if (fees[i][0] >= usage) {
                common = fees[i][1];
                maxidx = i;
                break;
            }
        }
        int fee;
        if (maxidx == 0) {
            fee = fees[0][2] * usage;
        } else {
            fee = fees[0][2] * fees[0][0];
            usage -= fees[0][0];
        }

        for (int i = 1; i <= maxidx; i++) {
            if (i == maxidx) {
                fee += fees[i][2] * usage;
                break;
            }
            fee += fees[i][2] * (fees[i][0] - fees[i - 1][0]);
            usage -= (fees[i][0] - fees[i - 1][0]);
        }
        return common + fee;
    }

    public static void main(String[] args) {
        P1 p1 = new P1();
        p1.solution(new int[][]{{200, 910, 93},
                {400, 1600, 188},
                {655, 7300, 281},
                {0, 15372, 435}}, 320);
    }
}
