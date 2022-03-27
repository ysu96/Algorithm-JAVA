package JAVA.BOJ.자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1088_케이크 {
     public static int N, M;
     public static PriorityQueue<Double> high = new PriorityQueue<>(Collections.reverseOrder());
     public static PriorityQueue<Double> low = new PriorityQueue<>();

     public static void main(String[] args) throws IOException {
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          N = Integer.parseInt(br.readLine());
          StringTokenizer st = new StringTokenizer(br.readLine());
          for(int i=0; i<N; i++){
               double cake = Double.parseDouble(st.nextToken());
               high.add(cake);
               low.add(cake);
          }
          M = Integer.parseInt(br.readLine());
          double answer;
          if(N == 0){
               answer = 0;
          }else if(N==1){
               answer = 0;
          }else{
               answer = high.peek() - low.peek();
               while(M > 0){
                    double highest = high.poll();
                    double newCake = highest / 2;
                    high.add(newCake);
                    high.add(newCake);
                    low.add(newCake);
                    low.add(newCake);
                    System.out.println("high : " + high.peek());
                    System.out.println("low : " + low.peek());
                    answer = Math.min(high.peek() - low.peek(), answer);
                    M--;
               }

          }
          System.out.println(answer);
     }
}
