package JAVA.BOJ.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_2239_스도쿠 {
    public static int[][] board = new int[9][9];
    public static List<int[]> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 9; i++) {
            String line = br.readLine();
            for (int j = 0; j < 9; j++) {
                board[i][j] = Character.getNumericValue(line.charAt(j));
                if (board[i][j] == 0) list.add(new int[]{i, j});
            }
        }
        write(0);
    }

    public static void write(int level) {
        if (level == list.size()) {
            print();
            System.exit(0);

        }

        int x = list.get(level)[0];
        int y = list.get(level)[1];

        //빈칸에 적을 수 있는 숫자 체크
        boolean[] check = new boolean[10];
        for (int i = 0; i < 9; i++) {
            if (board[x][i] != 0) check[board[x][i]] = true;  //가로
            if (board[i][y] != 0) check[board[i][y]] = true;  //세로
        }
        // 3x3
        int sx = (x / 3) * 3;
        int sy = (y / 3) * 3;
        for(int i=sx; i<sx+3; i++){
            for(int j=sy; j<sy+3; j++){
                if(board[i][j] != 0) check[board[i][j]] = true;
            }
        }

        for(int i=1;  i<10; i++){
            if(!check[i]){
                board[x][y] = i;
                write(level + 1);
                board[x][y] = 0;
            }
        }

    }

    public static void print() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
}
