package JAVA.Programmers.src.Level1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class K번째수 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int i =0; i < commands.length ; i++){
            int ii = commands[i][0];
            int jj = commands[i][1];
            int kk = commands[i][2];
            List<Integer> temp_array = new ArrayList<Integer>();
            for(int j = ii-1; j < jj; j++){
                temp_array.add(array[j]);
            }
            Collections.sort(temp_array);
            answer[i] = temp_array.get(kk-1);
        }
        return answer;
    }
}
