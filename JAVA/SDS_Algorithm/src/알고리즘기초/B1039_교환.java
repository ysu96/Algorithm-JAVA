package 알고리즘기초;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

//************* 교환 *****************

public class B1039_교환 {
    private static int N;
    private static int K;
    private static Queue<Integer> q = new LinkedList<Integer>();

    public static boolean isok(int num) {
        // 예외가 되는 것들은 바로처리
        // 1 ~ 9 ==> 교환이 안됨 ==> -1
        if (num < 10) return false;
        // 10, 20, .. .90 ==> 교환이 안됨 ==> -1
        if (num < 100 && num % 10 == 0) return false;
        return true;
    }

    public static int get_num_len(int num) {
        int len = 0;
        while (num > 0) {
            len++;
            num /= 10;
        }
        return len;
    }

    static int tonum(String arr) {
        int res = 0;
        for (int i = 0 ; i<arr.length() ; i++) {
            res *= 10;
            res += arr.charAt(i) - '0';
        }
//        System.out.println(res);
        return res;
    }

    static int conv(int num, int l, int r) {
        // l과 r의 체크가 안되어있음
        // 처음에 num의 자리수는 정해져있기때문에 그걸 이용하면  됨
        // arr
//        char[] buf = new char[16];
        String num2 = Integer.toString(num);
//        for(int i=0; i<num2.length(); i++){
//            buf[i] = num2.charAt(i);
//        }


        char tmp;
        tmp = num2.charAt(l);
        String buf = num2.substring(0,l)+Character.toString(num2.charAt(r))+
                num2.substring(l+1,r) + Character.toString(num2.charAt(l)) + num2.substring(r+1);
        // swap
//        tmp = buf[l];
//        buf[l] = buf[r];
//        buf[r] = tmp;
//        // 앞자리가 0이 아닌지 체크도..
//        if (buf[0] == '0') return 0;
        return tonum(buf);
    }

    public static void main(String[] args) throws Exception{
        // todo - 완전탐색
        // 숫자를 직접 교환하는 로직
        // 교환해서 단계별로 탐색해가는 로직
        // 그리고 답 구하면 됨
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (!isok(N)) {
            System.out.println(-1);
            return;
        }

        q.add(N);

        for (int i = 0 ; i < K ; i++) {
            // q --> next_q --> q
            // 단계별로 처리하기 위해서
            // 다음번 작업을 하기전에 임시로 저장하는 곳이고
            // q size를 이용해서 어찌어찌 처리를 하면 필요가 없어요 ==> 고민해보시면 됨
            List<Integer> next_q = new ArrayList<Integer>();

            while (!q.isEmpty()) {
                int cur = q.poll();
                int len = get_num_len(cur);
                for (int s = 0 ; s < len ; s++) {
                    for (int e = s + 1 ; e < len ; e++) {
                        int next_num = conv(cur, s, e);
                        if (next_num == 0) continue;
                        // 꼭 다 넣어야할까????
                        // 현재 다음번 처리는 "중복"이 발생하고 있습니다
                        // 적절하게 처리해 중복을 피해봅시다
                        if(!next_q.contains(next_num)) next_q.add(next_num);
                    }
                }
            }

            for (int j = 0 ; j < next_q.size() ; j++) {
                q.add(next_q.get(j));
            }
        }

        // k번을 돌렸기 때문에 q에남아 있는 것들은 k번을 수행하고 남은 숫자들이고
        // q에 남은것 중에 가장 큰것을 출력하면 됨
        int ans = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            if (ans < cur) ans = cur;
        }
        System.out.println(ans);

    }
}
