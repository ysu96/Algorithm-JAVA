package 정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//브루트포스
public class BOJ_2309_난쟁이 {
    public static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[9];
        for(int i=0; i<9; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        int tmp = Arrays.stream(arr).sum();
        for(int i=0; i<9; i++){
            for(int j=i+1; j<9; j++){
                if(tmp - arr[i] - arr[j] == 100){
                    for(int k=0; k<9; k++){
                        if(k==i || k==j) continue;
                        System.out.println(arr[k]);
                    }
                    return;
                }
            }
        }
    }
}
