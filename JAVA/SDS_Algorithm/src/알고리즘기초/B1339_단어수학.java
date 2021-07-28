package 알고리즘기초;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class B1339_단어수학 {
    private static int N,ans;
    private static List<String> arr = new ArrayList<String>();
    private static Map<Character, Double> result = new HashMap<Character, Double>();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            arr.add(st.nextToken());
        }

        for(String str : arr){
            int l = str.length();
            for(int i=0; i<l; i++){
                double a = Math.pow(10,l-i-1);
                if(result.containsKey(str.charAt(i))){
                    result.put(str.charAt(i), result.get(str.charAt(i))+a);
                }
                else {
                    result.put(str.charAt(i), a);
                }
            }
        }

        // Comparator 정의
        Comparator<Map.Entry<Character, Double>> comparator = new Comparator<Map.Entry<Character, Double>>() {
            @Override
            public int compare(Map.Entry<Character, Double> e1, Map.Entry<Character, Double> e2) {
                return e1.getValue().compareTo(e2.getValue());
            }
        };
        int cnt = 9;
        while(!result.isEmpty()){
            // Max Value의 key, value
            Map.Entry<Character, Double> maxEntry = Collections.max(result.entrySet(), comparator);
            ans+=maxEntry.getValue()*cnt;
            result.remove(maxEntry.getKey());
            cnt--;
        }

        // 결과 출력
        System.out.println(ans);
    }
}
// 알파벳이 주어지면
// 알파벳별로 숫자를 하나씩 매핑해보는게 일입니다.
// 최대 10개가 주어지는데....경우의수?????
// 이렇게 만든 경우의수에 대해서
// 직접 숫자을 대입해서 합을구하고, 최대값을 찾는다....

// 두번째 ==> 숫자를 그대로이용하는 방법
// ABCD : 1000 * A + 100 * B + 10 * C + D
// GCD : 100 * G + 10 * C + D
// EFABC : 10000 * E + 1000 * F + 100 * A + 10 * B + C
// ----------------------------------------------------
// 1100 * A + 110 * B + 21 * C + 2 * D + 10000 * E + 1000 * F + 100 * G
