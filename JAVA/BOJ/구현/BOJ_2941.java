package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

//크로아티아 알파벳
public class BOJ_2941 {
    public static Set<String> set = new HashSet<>();
    public static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        set.add("c=");
        set.add("c-");
        set.add("dz=");
        set.add("d-");
        set.add("lj");
        set.add("nj");
        set.add("s=");
        set.add("z=");
        String tmp;
        for(int i=0; i<s.length(); i++){
            if(i == s.length()-1){
                answer++;
                continue;
            }
            tmp = s.substring(i,i+2);
//            System.out.println(tmp);
            if (set.contains(tmp)) {
                answer++;
                i++;
            }
            else if (tmp.equals("dz")) {
                if(i+2 < s.length()){
                    if(s.charAt(i+2)=='='){
//                        System.out.println("--");
                        answer++;
                        i+=2;
                    }
                    else{
                        answer++;
                    }
                }
                else{
                    answer++;
                }

            }
            else{
                answer++;
            }
        }
        System.out.println(answer);
    }
}
