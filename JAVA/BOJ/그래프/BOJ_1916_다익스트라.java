package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Bus implements Comparable<Bus> {
    int end;
    int weight;

    Bus(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Bus o) {
        return weight-o.weight;
    }
}

//최소비용 구하기 - 다익스트라
public class BOJ_1916_다익스트라 {
    public static int n;
    public static int m;
    public static int[] distance;
    public static ArrayList<Bus>[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        distance = new int[n+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        arr = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            arr[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            arr[r].add(new Bus(c,w));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        distance[start] = 0;

        dijkstra(start);
        System.out.println(distance[end]);

    }

    public static void dijkstra(int start){
        PriorityQueue<Bus> pq = new PriorityQueue<>();
        pq.add(new Bus(start, 0));
        boolean[] check = new boolean[n+1];

        while (!pq.isEmpty()){
            Bus poll = pq.poll();
            if(check[poll.end]) continue;
            check[poll.end] = true;
            for(Bus bus : arr[poll.end]){
                if (bus.weight + distance[poll.end] < distance[bus.end]) {
                    distance[bus.end] = bus.weight + distance[poll.end];
                    pq.add(new Bus(bus.end, distance[bus.end]));
                }
            }
        }
    }
}
