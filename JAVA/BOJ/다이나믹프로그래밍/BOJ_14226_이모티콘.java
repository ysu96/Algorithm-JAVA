package 다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Emoticon{
    int clip;
    int screen;
    int time;

    Emoticon(int screen, int clip, int time) {
        this.screen = screen;
        this.clip = clip;
        this.time = time;
    }
}

public class BOJ_14226_이모티콘 {
    public static int s;
    public static boolean[][] visited = new boolean[1001][1001]; //클립보드 수, 스크린 수
    public static Queue<Emoticon> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = Integer.parseInt(br.readLine());
        bfs();
    }

    public static void bfs(){
        queue.add(new Emoticon(1,0,0));
        visited[1][0] = true;
        while (!queue.isEmpty()) {
            Emoticon cur = queue.poll();
            if (cur.screen == s) {
                System.out.println(cur.time);
                return;
            }
            //복사
            queue.add(new Emoticon(cur.screen, cur.screen, cur.time + 1));

            //붙여넣기
            if (cur.clip != 0 && cur.screen + cur.clip <= s && !visited[cur.screen+cur.clip][cur.clip]) {
                queue.add(new Emoticon(cur.screen+cur.clip, cur.clip, cur.time+1));
                visited[cur.screen+cur.clip][cur.clip] = true;
            }

            //삭제
            if (cur.screen>=1 && !visited[cur.screen-1][cur.clip]) {
                queue.add(new Emoticon(cur.screen-1, cur.clip, cur.time+1));
                visited[cur.screen-1][cur.clip] = true;
            }
        }

    }
}
