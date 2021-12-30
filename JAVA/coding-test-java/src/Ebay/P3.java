package Ebay;

class Loc{
    int r,c, dir;
    Loc(int r, int c, int dir){
        this.r = r;
        this.c = c;
        this.dir = dir;
    }
}
public class P3 {
    public static int answer = 0;
    public static void travel(String[] grid, Loc start){
        //dir 0 : 왼쪽에서 시작, dir 1: 아래, dir 2: 오른쪽
        // 역삼각 dir 3 : 위
        int fr = start.r;
        int fc = start.c;
        int fd = start.dir;
        int cnt = 0;
        while(true){
            int dir = start.dir;
            int r = start.r;
            int c = start.c;

            //탈출 불가
            if(fr == r && fc == c && fd == dir && cnt!=0) break;

            //탈출
            if(r<0 || r>= grid.length || c<0 || c>=(2*r+1)){
                answer = Math.max(answer, cnt);
                break;
            }

            //파랑, 왼쪽
            if(grid[r].charAt(c) == 'B'){
                // 왼쪽에서 들어옴;
                if(dir == 0){
                    //정삼각형
                    if(c%2==0){
                        start = new Loc(r, c+1, 0);
                    }
                    //역삼각형
                    else {
                        start = new Loc(r-1, c-1, 1);
                    }
                }
                //아래에서 들어옴
                else if(dir == 1){
                    //정삼각형
                    if(c%2 == 0){
                        start = new Loc(r, c-1, 2);
                    }
                    //역삼각형
//                    else{
//                        start = new Loc()
//                    }
                }
                //오른쪽
                else if(dir == 2){
                    if(c%2==0){
                        start = new Loc(r+1, c+1, 3);
                    }
                    else{
                        start = new Loc(r, c-1, 2);
                    }
                }
                //위
                else{
                    if(c%2==1){
                        start = new Loc(r, c+1, 0);
                    }
                }
                cnt++;
            }
            //빨강, 오른쪽
            else{
                // 왼쪽에서 들어옴;
                if(dir == 0){
                    //정삼각형
                    if(c%2==0){
                        start = new Loc(r+1, c+1, 3);
                    }
                    //역삼각형
                    else {
                        start = new Loc(r, c+1, 2);
                    }
                }
                //아래에서 들어옴
                else if(dir == 1){
                    //정삼각형
                    if(c%2 == 0){
                        start = new Loc(r, c+1, 0);
                    }

                }
                //오른쪽
                else if(dir == 2){
                    if(c%2==0){
                        start = new Loc(r, c-1, 2);
                    }
                    else{
                        start = new Loc(r-1, c-1, 1);
                    }
                }
                //위
                else{
                    if(c%2==1){
                        start = new Loc(r, c-1, 2);
                    }
                }
                cnt++;
            }
        }
    }

    public int solution(String[] grid) {
        for(int i=0; i<3; i++){
            for(int j=0; j<grid.length; j++){
                // i==0 : 왼쪽변
                if(i==0){
                    Loc start = new Loc(j, 0, i);
                    travel(grid,start);
                }
                // i==1 : 아래변
                if(i==1){
                    Loc start = new Loc(grid.length-1, j*2, i);
                    travel(grid,start);
                }
                // i==2 : 오른쪽변
                if(i==2){
                    Loc start = new Loc(j, 2*j, i);
                    if(j==3) System.out.println("----------");
                    travel(grid,start);
                }

            }
        }
        System.out.println(answer);
        return answer;
    }

    public static void main(String[] args) {
        P3 p3 = new P3();
        p3.solution(new String[]{"R", "RRR", "RBBBB", "BRRRBRR"});
    }
}
