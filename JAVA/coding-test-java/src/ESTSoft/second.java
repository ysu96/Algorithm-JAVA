package ESTSoft;

import java.util.HashSet;

public class second {
    public static boolean[] visited; //선택 후보
    public static int[][] need;
    public static int ans;

    public int solution(int[][] needs, int r) {
        need = needs;
        int n = needs[0].length;
        if(n == r) return needs.length;
        visited = new boolean[n];
        combination(visited, 0, n, r);
        return ans;
    }
    static void getAns(){
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<visited.length; i++){
            if(visited[i]) set.add(i);
        }
        int tmp = 0;
        for (int[] arr : need) {
            boolean check = true;
            for(int i=0; i<arr.length; i++){
                if(arr[i] == 1 && !set.contains(i)) {
                    check = false;
                    break;
                }
            }
            if (check) tmp++;
        }
        ans = Math.max(ans, tmp);
    }
    static void combination(boolean[] visited, int start, int n, int r) {
        if(r == 0) {
            getAns();
            return;
        }
        for(int i=start; i<n; i++) {
            visited[i] = true;
            combination(visited, i + 1, n, r - 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        second s = new second();
        int a =s.solution(new int[][]{{1, 0, 0 }, {1, 1, 0}, {1, 1, 0}, {1, 0, 1}, {1, 1, 0}, {0, 1, 1}},3);
        System.out.println(a);
    }
}
