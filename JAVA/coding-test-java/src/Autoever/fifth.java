package Autoever;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class fifth {
    public static boolean search(int a, List<Integer> list, int start, int end){
        int mid = (int) (start+end)/2;
        if(end<start) return false;
        if(list.get(mid) == a) return true;
        else if (list.get(mid) > a) return search(a, list, start, mid-1);
        else return search(a, list, mid+1, end);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        List<Integer> pp = new ArrayList<>();
        st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++){
            int p = Integer.parseInt(st.nextToken());
            pp.add(p);
        }
        Collections.sort(pp);
        int minimum = 0;
        for(int i=0; i<N; i++){
            int tmp = pp.get(i);
            if(search(S-tmp, pp, 0, pp.size()-1)){ // S-i : 틀림 후
//                minimum = i; 틀렷다
                minimum = tmp;
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(minimum).append(" ").append(S-minimum);
        System.out.println(sb);

    }
}
