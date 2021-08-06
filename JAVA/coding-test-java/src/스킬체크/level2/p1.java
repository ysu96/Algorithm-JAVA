package 스킬체크.level2;

public class p1 {
    public int gcd(int a, int b) {
        while (b != 0) {
            int r = a % b; // 나머지를 구해준다.
            // GCD(a, b) = GCD(b, r)이므로 변환한다.
            a = b;
            b = r;
        }
        return a;
    }

    public int solution(int[] arr) {
        int answer = 0;
        int max = arr[0];
        for(int i=1; i< arr.length; i++){
            int min = gcd(max, arr[i]);
            max = max*arr[i]/min;
        }
        return max;
    }
}
