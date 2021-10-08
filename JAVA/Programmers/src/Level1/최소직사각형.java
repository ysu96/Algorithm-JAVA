package Level1;

public class 최소직사각형 {
    public int solution(int[][] sizes) {
        int answer = 0;
        int maxHeight = 0, maxWidth=0;
        for(int i=0; i<sizes.length; i++){
            maxHeight = Math.max(Math.max(sizes[i][0], sizes[i][1]), maxHeight);
        }

        for(int i=0; i<sizes.length; i++){
            maxWidth = Math.max(Math.min(sizes[i][0], sizes[i][1]), maxWidth);
        }
        answer = maxHeight*maxWidth;
        return answer;
    }
}
