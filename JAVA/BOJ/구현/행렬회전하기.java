package JAVA.BOJ.구현;

public class 행렬회전하기 {
    public static void main(String[] args) {
        rotate(4, true);
    }

    public static void rotate(int N, boolean clockwise){
        int[][] arr = new int[N][N];
        int num = 1;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                arr[i][j] = num++;
            }
        }
        print(arr);

        int[][] tmp = new int[N][N];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                tmp[j][N-1-i] = arr[i][j];
            }
        }

        print(tmp);

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                tmp[N-1-j][i] = arr[i][j];
            }
        }

        print(tmp);

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                tmp[i][N-1-j] = arr[i][j];
            }
        }
        print(tmp);

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                tmp[N-1-i][j] = arr[i][j];
            }
        }
        print(tmp);

    }

    public static void print(int[][] arr){
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                System.out.print("" + arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
