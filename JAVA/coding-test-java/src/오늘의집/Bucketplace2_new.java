package 오늘의집;

public class Bucketplace2_new {
    public String solution(String call) {
        String copied_str = new String(call);
        call = call.toLowerCase();
        int n = call.length();
        int[] count = new int[26];
        int maxval = 0;
        for (int i = 0; i < n; i++) {
            char c = call.charAt(i);
            count[c - 'a']++;
            maxval = Math.max(maxval, count[c - 'a']);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char c = call.charAt(i);
            if (maxval != count[c - 'a']) {
                sb.append(copied_str.charAt(i));
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Bucketplace2_new bc2 = new Bucketplace2_new();
        System.out.println(bc2.solution("abcabcdefabc"));
        System.out.println(bc2.solution("abxdeydeabz"));
        System.out.println(bc2.solution("abcabca"));
        System.out.println(bc2.solution("ABCabcA"));
    }
}
