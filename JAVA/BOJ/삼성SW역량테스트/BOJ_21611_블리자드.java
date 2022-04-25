package JAVA.BOJ.삼성SW역량테스트;

import java.io.IOException;
import java.io.*;
import java.util.StringTokenizer;

public class BOJ_21611_블리자드 {
    static int N, M, answer;
    static int[][] magic;
    static int[][] arr; // 구슬 번호
    static int[][] num; // 일자로 폈을 때 인덱스 번호를 계산하는 배열
    static int[] snail; // 일자로 폈을 때 배열
    static int[] answers;

    // ↑, ↓, ←, →가 있고, 정수 1, 2, 3, 4
    static int[] dr = { 0, -1, 1, 0, 0 };
    static int[] dc = { 0, 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        num = new int[N][N];
        magic = new int[M][2];
        snail = new int[N * N];
        answers = new int[4];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            magic[i][0] = Integer.parseInt(st.nextToken());
            magic[i][1] = Integer.parseInt(st.nextToken());
        }

        snail_number();

        for (int i = 0; i < M; i++) {
            int d = magic[i][0];
            int s = magic[i][1];
            blizzard(d, s);

            while (!bomb()) {
                compress();
            }

            convert();
//			printSnail();
        }
        answer = answers[1] + answers[2] * 2 + answers[3] * 3;
        System.out.println(answer);
    }

    public static void printSnail() {
        for (int i = 0; i < N * N; i++) {
            System.out.print("" + snail[i] + "");
        }
        System.out.println();
    }

    public static void snail_number() { // 나선형 번호 매기기
        int[] dr = { 0, 1, 0, -1 };
        int[] dc = { 1, 0, -1, 0 };
        int r = 0, c = 0, d = 0, v = N * N - 1;
        while (v > 0) {
            snail[v] = arr[r][c];
            num[r][c] = v--;
            while (true) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if ((nr < 0 || nc < 0 || nr >= N || nc >= N) || num[nr][nc] != 0) {
                    d = (d + 1) % 4;
                    continue;
                }
                r = nr;
                c = nc;
                break;
            }
        }
    }

    public static void blizzard(int d, int s) { // 얼음 던지기
        int r = N / 2, c = N / 2;
        for (int i = 0; i < s; i++) {
            r += dr[d];
            c += dc[d];
            snail[num[r][c]] = 0;
        }
        compress();
    }

    public static void compress() { // 빈 칸 압축
        int last = 1;
        for (int i = 1; i < N * N; i++) {
            if (snail[i] == 0)
                continue;
            snail[last++] = snail[i];
        }
        for (int i = last; i < N * N; i++) {
            snail[i] = 0;
        }
    }

    public static boolean bomb() { // 구슬 폭발
        boolean done = true;
        for (int i = 1; i < N * N; i++) {
            if (snail[i] == 0)break;

            int j = i; // i~j까지 연속하는 구슬 찾기
            while (j + 1 < N * N && snail[i] == snail[j + 1]) {
                j++;
            }
            if (j - i + 1 >= 4) {
                answers[snail[i]] += j - i + 1;
                done = false;
                for (int k = i; k <= j; k++) {
                    snail[k] = 0;
                }
            }
            i = j;
        }
//		for (int i = 2; i < N * N; i++) {
//			if (snail[i] == num && snail[i] != 0) {
//				cnt++;
//			} else {
//				if (cnt >= 4) { // 폭발
//					done = false;
//					int j = i - 1;
//					while (cnt > 0) {
//						answers[snail[j]]++;
//						snail[j--] = 0;
//						cnt--;
//					}
//				}
//				num = snail[i];
//				if (num == 0)
//					break;
//				cnt = 1;
//			}
//		}
//
//		if (cnt >= 4) {
//			done = false;
//			int j = N * N - 1;
//			while (cnt > 0) {
//				answers[snail[j]]++;
//				snail[j--] = 0;
//				cnt--;
//			}
//		}
        return done;
    }

    public static void convert() { // 구슬 변환
        int[] tmp = new int[N * N];
        int idx = 1;

        for(int i=1; i<N*N; i++) {
            if(snail[i] == 0) break;
            int j = i;
            while(j+1 < N*N && snail[i] == snail[j+1]) {
                j++;
            }
            int cnt = j-i+1;
            int group = snail[i];
            tmp[idx++] = cnt;
            tmp[idx++] = group;
            if(idx == N*N) break;
            i = j;
        }

//		for (int i = 2; i < N * N; i++) {
//			if (snail[i] == group) {
//				cnt++;
//			} else {
//				if (idx == N * N)
//					break;
//
//				tmp[idx++] = cnt;
//				tmp[idx++] = group;
//				group = snail[i];
//				if (group == 0) {
//					cnt = 0;
//					break;
//				}
//				cnt = 1;
//			}
//		}
//		if (idx < N * N && cnt > 0) {
//			tmp[idx++] = cnt;
//			tmp[idx++] = group;
//		}

        snail = tmp;
    }
}
