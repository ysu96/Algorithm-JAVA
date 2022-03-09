package JAVA.BOJ.BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_9328_열쇠_BFS {
    public static int T, h, w, answer;
    public static char[][] map;
    public static boolean[] keys;
    public static boolean[][] visited;
    public static List<Point>[] doors;

    static class Point {
        int r;
        int c;

        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            map = new char[h + 2][w + 2];
            keys = new boolean[26];
            visited = new boolean[h + 2][w + 2];
            doors = new List[26];
            answer = 0;
            for(int i=0; i<26; i++){
                doors[i] = new ArrayList<>();
            }

            for (int i = 0; i < w + 2; i++) {
                map[0][i] = '.';
                map[h + 1][i] = '.';
            }
            for (int i = 0; i < h + 2; i++) {
                map[i][0] = '.';
                map[i][w + 1] = '.';
            }

            for (int i = 0; i < h; i++) {
                String line = br.readLine();
                for (int j = 0; j < w; j++) {
                    map[i + 1][j + 1] = line.charAt(j);
                }
            }

            String k = br.readLine();
            if(!k.equals("0")){
                for (int i = 0; i < k.length(); i++) {
                    keys[k.charAt(i) - 'a'] = true;
                }
            }

            bfs();
            System.out.println(answer);
        }
    }

    public static void bfs() {
        int[] dr = {0, 0, -1, 1};
        int[] dc = {-1, 1, 0, 0};
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0));
        visited[0][0] = true;

        while (!q.isEmpty()) {
            Point cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                if (!validate(nr, nc)) continue;
                if(visited[nr][nc]) continue;
                char c = map[nr][nc];
                if (c == '*') continue;

                if (c >= 'a' && c <= 'z') {
                    if(!keys[c - 'a']){
                        keys[c - 'a'] = true;
                        // key얻었으니깐 못 들어갔던곳도 뚫자
                        for(Point p : doors[c-'a']){
                            q.add(new Point(p.r, p.c));
                            visited[p.r][p.c] = true;
                        }
                    }
                    visited[nr][nc] = true;
                    q.add(new Point(nr, nc));

                } else if (c >= 'A' && c <= 'Z') {
                    if (keys[c + 32 - 'a']) {
                        visited[nr][nc] = true;
                        q.add(new Point(nr, nc));
                    } else {
                        doors[c - 'A'].add(new Point(nr, nc));
                    }
                } else if (c == '.') {
                    visited[nr][nc] = true;
                    q.add(new Point(nr, nc));
                } else if(c == '$'){
                    answer++;
                    visited[nr][nc] = true;
                    q.add(new Point(nr, nc));
                }
            }
        }
    }

    public static boolean validate(int r, int c) {
        return (r >= 0 && r < h + 2 && c >= 0 && c < w + 2);
    }
}
