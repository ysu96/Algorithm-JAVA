package 라인스튜디오인턴;

//r행 c열의 빈 격자가 있습니다. 당신은 이 격자를 ㄷ 모양으로 순회하면서 격자를 채우고자 합니다.
//
//ㄷ 모양으로 채우는 방법은 다음과 같습니다.
//
//격자의 우측 상단부터 채우기 시작합니다.
//격자의 끝에 도착하거나 이미 방문한 격자를 만날 때까지 왼쪽으로 움직입니다.
//격자의 끝에 도착하거나 이미 방문한 격자를 만날 때까지 아래로 움직입니다.
//격자의 끝에 도착하거나 이미 방문한 격자를 만날 때까지 오른쪽으로 움직입니다.
//위로 한 칸 움직입니다.
//격자의 끝에 도착하거나 이미 방문한 격자를 만날 때까지 왼쪽으로 움직입니다.
//격자의 끝에 도착하거나 이미 방문한 격자를 만날 때까지 위로 움직입니다.
//격자의 끝에 도착하거나 이미 방문한 격자를 만날 때까지 오른쪽으로 움직입니다.
//아래로 한 칸 움직입니다.
//2 ~ 9번을 반복합니다.
//각 번호를 실행하다 격자를 다 채우게 되면 반복을 멈추고 종료합니다.
//예를 들어 r = 8, c = 6인 경우 아래 그림과 같이 격자를 채우게 됩니다.

//정수 r, c가 매개변수로 주어집니다. ㄷ 모양으로 순회하며 채운 격자를 2차원 정수 배열로 return 하도록 solution 함수를 완성해주세요.

public class Line2 {
    public boolean check(int[][] arr){
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                if(arr[i][j] == 0){
                    return false;
                }
            }
        }
        return true;
    }
    public int[][] solution(int r, int c) {
        int[][] answer = new int[r][c];
        int cnt = 1;
        answer[0][c-1] = 1;
        cnt++;
        //1번
        int nowr= 0;
        int nowc= c-1;
        while(true){
            //2번
            for(int i=nowc-1; i>=0; i--){
                //이미 방문한 격자
                if(answer[nowr][i] != 0){
                    break;
                }
                answer[nowr][i] = cnt;
                cnt++;
                nowc = i;
                if(check(answer)){
                    return answer;
                }
            }

            //3번
            for(int i=nowr+1; i<r; i++){
                if(answer[i][nowc] != 0){
                    break;
                }
                answer[i][nowc] = cnt;
                cnt++;
                nowr = i;
                if(check(answer)){
                    return answer;
                }
            }

            //4
            for(int i=nowc+1; i<c; i++){
                if(answer[nowr][i] != 0) break;
                answer[nowr][i] = cnt;
                cnt++;
                nowc = i;
                if(check(answer)){
                    return answer;
                }
            }

            //5
            nowr--;
            answer[nowr][nowc] = cnt;
            cnt++;
            if(check(answer)){
                return answer;
            }

            //6
            for(int i=nowc-1; i>=0; i--){
                //이미 방문한 격자
                if(answer[nowr][i] != 0){
                    break;
                }
                answer[nowr][i] = cnt;
                cnt++;
                nowc = i;
                if(check(answer)){
                    return answer;
                }
            }

            //7
            for(int i=nowr-1; i>=0; i--){
                if(answer[i][nowc] != 0) break;
                answer[i][nowc] = cnt;
                cnt++;
                nowr = i;
                if(check(answer)) return answer;
            }

            //8
            for(int i=nowc+1; i<c; i++){
                if(answer[nowr][i] != 0) break;
                answer[nowr][i] = cnt;
                cnt++;
                nowc = i;
                if(check(answer)){
                    return answer;
                }
            }

            //9
            nowr++;
            answer[nowr][nowc] = cnt;
            cnt++;
            if(check(answer)){
                return answer;
            }
        }

    }

    public static void main(String[] args) {
        Line2 l2 = new Line2();
        int[][] solution = l2.solution(5, 4);
        for(int i=0; i<5; i++){
            for(int j=0; j<4; j++){
                System.out.print(solution[i][j]);
            }
            System.out.println();
        }
    }
}
