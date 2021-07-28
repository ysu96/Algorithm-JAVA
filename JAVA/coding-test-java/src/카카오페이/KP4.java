//package 카카오페이;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.PriorityQueue;
//
//public class KP4 {
//    class Node implements Comparable<Node>{
//        int id;
//        long age;
//
//        Node(int id, long age){
//            this.id = id;
//            this.age = age;
//        }
//        @Override
//        public int compareTo(Node o) {
//            if(age < o.age) return -1;
//            else return 1;
//        }
//    }
//
//    class Wire implements Comparable<Wire> {
//        int start;
//        int end;
//        int dist;
//        Wire(int start, int end, int dist){
//            this.start = start;
//            this.end = end;
//            this.dist = dist;
//        }
//        @Override
//        public int compareTo(Wire o) {
//            if (dist < o.dist) return -1;
//            else return 1;
//        }
//    }
//
//
//    public int[] solution(long[] ages, int[][] wires){
//
//        PriorityQueue<Node> arr = new PriorityQueue<Node>();
//        PriorityQueue<Wire> arr2 = new PriorityQueue<Wire>();
//        int N = ages.length;
//        ArrayList<Integer> answer = new ArrayList<Integer>();
//
//        int[][] graph = new int[N+1][N+1];
//        for(int i=0; i<=N; i++){
//            for(int j=0; j<=N; j++){
//                graph[i][j] = -1;
//            }
//        }
//
//        for(int i=0; i<N; i++){
//            arr.add(new Node(i+1,ages[i]));
//        }
////        Collections.sort(arr);
//
//        for(int[] wire : wires){
//            int start = wire[0];
//            int end = wire[1];
//            int length = wire[2];
//            graph[start][end] = length;
//        }
//
////        long max_age = arr.get(arr.size()-1).age;
//        Node node = arr.poll();
//        long cur_age = node.age;
//        int cur_id = node.id;
//        for(int z=1; z<=N; z++){
//            if(graph[cur_id][z] != -1){
//                arr2.add(new Wire(cur_id,z,graph[cur_id][z]));
//            }
//        }
//        answer.add(cur_id);
//
//        while(!arr2.isEmpty()){
//            Wire wire = arr2.poll();
//            if(wire.dist + cur_age < wire.end)
//
//            if(answer.size() ==0) {
//                answer.add(cur_id);
//                continue;
//            }
//
//            //하나 빼면 연결 선 지우기??
//        }
//
//        return answer;
//    }
//
//    public static void main(String[] args) {
//        KP4 k = new KP4();
//        k.solution(new long[]{8,13,5,8}, new int[][]{{1,3,10},{3,4,1},{4,2,2},{2,1,3}});
//    }
//}
