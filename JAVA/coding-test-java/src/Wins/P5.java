package Wins;

import java.util.*;

public class P5 {
    public static List<String> newDir;

    public String[] solution(String[] directory, String[] command) {
        newDir = new ArrayList<>();
        for(String s : directory){
            newDir.add(s);
        }

        for (String c : command) {
            StringTokenizer st = new StringTokenizer(c);
            String op = st.nextToken();

            if (op.equals("mkdir")) {
                String dir = st.nextToken();
                mkdir(dir);

                for (String s : newDir) {
                    System.out.println(s);
                }
                System.out.println();

            } else if (op.equals("cp")) {
                String source = st.nextToken();
                String dest = st.nextToken();
                cp(source, dest);

                for (String s : newDir) {
                    System.out.println(s);
                }
                System.out.println();

            } else { //rm
                String dir = st.nextToken();
                newDir = rm(dir);

                for (String s : newDir) {
                    System.out.println(s);
                }
                System.out.println();
            }
        }
        String[] answer = new String[newDir.size()];
        for (int i = 0; i < newDir.size(); i++) {
            answer[i] = newDir.get(i);
        }

        for (String s : answer) {
            System.out.println(s);
        }
        return answer;
    }

    public List<String> rm(String dir) {
        List<String> tmp = new ArrayList<>();
        for (String s : newDir) {
            if (!s.startsWith(dir)) {
                tmp.add(s);
            }
        }
        return tmp;
    }

    public int getSourceIdx(String source){
        // "cp /a/b /"
        // /a/b/c
        if(source.length() == 1) return 0;

        for(int i=source.length()-1; i>=0; i--){
            if (source.charAt(i) == '/') {
                return i;
            }
        }
        return -1;
    }

    public void cp(String source, String dest) {
        List<String> sourceDir = new ArrayList<>();
        int idx = getSourceIdx(source);

        if (dest.equals("/")) {
            for (String s : newDir) {
                if (s.startsWith(source)) {
                    sourceDir.add(s.substring(idx));
                }
            }
        }
        else{
            for (String s : newDir) {
                if (s.startsWith(source)) {
                    sourceDir.add(dest + s.substring(idx));
                }
            }
        }

        for (String s : sourceDir) {
            newDir.add(s);
        }
        Collections.sort(newDir);
    }

    public void mkdir(String dir) {
        newDir.add(dir);
        Collections.sort(newDir);
    }

    public static void main(String[] args) {
        P5 p5 = new P5();

        p5.solution(new String[]{"/"},
                new String[]{"mkdir /a", "mkdir /a/b"});
    }
}
