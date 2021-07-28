package ICT;

import java.util.*;

public class ICT3 {
    public static String reachTheEnd(List<String> grid, int maxTime) {
        // Write your code here
        int[][] graph = new int[grid.size()][grid.get(0).length()];
        boolean[][] visit = new boolean[grid.size()][grid.get(0).length()];
        int r = grid.size();
        int c = grid.get(0).length();

        for(int i=0; i<r; i++){
            String tmp = grid.get(i);
            for(int j=0; j<c; j++){
                if(tmp.charAt(j)=='#') graph[i][j] = 0;
                else graph[i][j] = 1;
                visit[i][j] = false;
            }
        }

        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};

        Queue<ArrayList<Integer>> q = new LinkedList<ArrayList<Integer>>();
        q.add(new ArrayList<Integer>(Arrays.asList(0,0,0)));

        while(!q.isEmpty()){
            ArrayList<Integer> a = q.poll();
            int x = a.get(0);
            int y = a.get(1);
            int t = a.get(2);

            if(x==r-1 && y==c-1){
                if(t > maxTime) return("No");
                else return("Yes");

            }

            for(int i=0;i<4;i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(nx>=r || nx<0 || ny>=c || ny<0) continue;
                if(graph[nx][ny] == 0) continue;

                if(visit[nx][ny]==false){
                    q.add(new ArrayList<>(Arrays.asList(nx,ny,t+1)));
                    visit[nx][ny] = true;
                }


            }
        }
        return("No");

    }

}
