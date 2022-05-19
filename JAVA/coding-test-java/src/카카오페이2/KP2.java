package 카카오페이2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class KP2 {
    // 크기 작은 정사각형부터
    // y값 가장 작은거, 그 다음 x값 작은거
    static ArrayList<int[]> answer = new ArrayList<>();
    static int[][] arr;
    static int r = 0, c = 0;
    static int N, M;

    public int[][] solution(int n, int m, int[][] rectangle) {
        Arrays.sort(rectangle, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] < o2[0]) return -1;
                else return 1;
            }
        });

        arr = new int[m][n];
        N = n;
        M = m;
        boolean flag = true;
        for (int i = 0; i < rectangle.length; i++) {
            int num = rectangle[i][1];
            int len = rectangle[i][0];

            for (int j = 0; j < num; j++) {
                while (r <= M-len && !isEmpty(len)) {
                    c++;
                    if (c > N - len) {
                        c = 0;
                        r++;
                    }
                }

                if (r > m-len) {
                    flag = false;
                    break;
                }
                System.out.println("r : " + r + " c : " + c + " len : " + len);
                fill(len);
            }

            if (!flag) break;
        }

        for (int[] a : answer) {
            System.out.println("" + a[0] + " " + a[1] + " " + a[2]);
        }

        int[][] ans = new int[answer.size()][3];
        for (int i = 0; i < answer.size(); i++) {
            ans[i][0] = answer.get(i)[0];
            ans[i][1] = answer.get(i)[1];
            ans[i][2] = answer.get(i)[2];

        }

        return ans;
    }

    public static boolean isEmpty(int len) {
        for (int i = r; i < r + len; i++) {
            for (int j = c; j < c + len; j++) {
                if (arr[i][j] != 0) return false;
            }
        }
        return true;
    }

    public static void fill(int len) {
        for (int i = r; i < r + len; i++) {
            for (int j = c; j < c + len; j++) {
                arr[i][j] = 1;
            }
        }
        answer.add(new int[]{c, r, len});

    }

    public static void main(String[] args) {
        KP2 kp2 = new KP2();
        int[][] rec = new int[][]{
                {1,90}
        };
        kp2.solution(7, 8, rec);
    }
}
//n	m	rectangle	result
//7	8	[[2,2],[1,4],[3,2]]	[[0,0,1],[1,0,1],[2,0,1],[3,0,1],[4,0,2],[0,1,2],[2,2,3],[0,5,3]]
