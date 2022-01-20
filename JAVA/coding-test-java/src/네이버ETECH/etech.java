package 네이버ETECH;

public class etech {
    // 통장 1,000  / 100  /  1,000,000
    String parse(int n) {
        String s = Integer.toString(n);
        int length = s.length();

//        if(length <= 3) return s;
//
//        int left = length % 3;
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < left; i++) {
//            sb.append(s.charAt(i));
//        }
//        sb.append(',');
//
//        int cnt = 0;
//        for(int i=left; i<length; i++){
//            sb.append(s.charAt(i));
//            cnt++;
//            if(cnt ) sb.append(',');
//        }

        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = length - 1; i >= 0; i--) {
            cnt++;
            sb.append(s.charAt(i));
            if (cnt == 3 && i != 0) {
                sb.append(',');
                cnt = 0;
            }
        }
        String tmp = sb.toString();
        sb = new StringBuilder();
        for (int i = tmp.length() - 1; i >= 0; i--) {
            sb.append(tmp.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        etech ee = new etech();
        System.out.println(ee.parse(1000));
        System.out.println(ee.parse(1000000));
        System.out.println(ee.parse(100));
        System.out.println(ee.parse(10));
        System.out.println(ee.parse(100000));
        System.out.println(ee.parse(Integer.MAX_VALUE));
        System.out.println(ee.parse(-100));
        System.out.println(ee.parse(0));
    }
}
