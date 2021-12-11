package Autoever;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Pill{
    int d;
    int e;
    Pill(int d, int e){
        this.d = d;
        this.e = e;
    }
}
public class fourth {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        List<Pill> list = new ArrayList<>();
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int di = Integer.parseInt(st.nextToken());
            int ei = Integer.parseInt(st.nextToken());
            list.add(new Pill(di, ei));
        }
        int answer = 0;
        for(int i=X; i>0; i--){
            int dayLeft = X-i+1;
            int maxIdx = -1;
            int maxE = -1;
            for(int j=0; j<list.size(); j++){
                Pill tmp = list.get(j);
                if (tmp.d <= dayLeft && tmp.e > maxE) {
                    maxE = tmp.e;
                    maxIdx = j;
                }
            }
            if(maxIdx != -1){
                answer+= list.get(maxIdx).e;
                list.remove(maxIdx);
            }
        }
        System.out.println(answer);

    }
}
