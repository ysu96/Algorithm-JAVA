package SKFamily;

public class SK_p2 {
    public int[][] solution(int n, boolean clockwise) {
        int[][] arr = new int[n][n];
        //꺾는 회수 = if(n%2) n/2 -1  /  if(n%2!=0) n/2
        int cnt = n % 2 == 0 ? n / 2 - 1 : n / 2;

        //시계방향
        if (clockwise) {
            int idx = 1;

            for(int k=0; k<=cnt; k++){

                for (int i = k; i < n - k - 1; i++) {
                    arr[k][i] = idx;
                    arr[n - 1 - k][n - 1 - i] = idx;
                    arr[n - 1 - i][k] = idx;
                    arr[i][n - 1 - k] = idx;
                    idx++;
                }
            }
            if (n % 2 == 1) {
                arr[n/2][n/2] = idx;
            }

        } else {
            int idx = 1;
            for(int k=0; k<=cnt; k++){
                for(int i=k; i<n-k-1; i++){
                    arr[k][n-1-i] = idx;
                    arr[n-1-k][i] = idx;
                    arr[i][k] = idx;
                    arr[n-1-i][n-1-k] = idx;
                    idx++;
                }
            }
            if (n % 2 == 1) {
                arr[n/2][n/2] = idx;
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                System.out.print(arr[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }

        return arr;
    }

    public static void main(String[] args) {
        SK_p2 p2 = new SK_p2();
        p2.solution(3, false);
    }
}
