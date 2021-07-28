package 알고리즘기초;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//************************ 후보 추천하기 ***************************

public class B1713_후보추천 {
    public static int n;
    public static int[] pic_frame = new int[20]; //사진들
    public static int num_cc; //추천 개수
    public static int[] ord_cc = new int[1000]; //추천 순서
    public static int[] cand_like = new int[101]; //후보 추천 횟수
    public static int[] cand_where = new int[101]; // 후보가 어떤 사진에 걸려있는지
    public static int[] cand_when = new int[101]; // 후보가 사진에 언제 올라갔는지

    public static int get_pic_frame(){
        for(int i=0; i<n; i++){
            if(pic_frame[i] == 0) return i;
        }

        //올라가있는 후보중 좋아요가 가장 적은 후보
        //같으면 오래전에 올라간 후보
        int res = 0; //최종 반환할 사진들의 위치
        int min_like = 1000;
        int old_when = 1000;
        for(int i=0; i<n; i++){
            int cur=pic_frame[i];
            int tmp_like = cand_like[cur];
            int tmp_when = cand_when[cur];
            if (tmp_like < min_like) {
                min_like = tmp_like;
                old_when = tmp_when;
                res = i;
            }
            else if (tmp_like == min_like && tmp_when < old_when){
                min_like = tmp_like;
                old_when = tmp_when;
                res = i;
            }
        }
        return res;
    }


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        num_cc = sc.nextInt();

        
        for(int i=0; i<num_cc; i++){
//            vote.add(sc.nextInt());
            ord_cc[i] = sc.nextInt();
        }

        //초기화
        for(int i=1; i<=100; i++){
            cand_where[i] = -1;
            cand_when[i] = -1;
        }

        for(int i=0; i<num_cc; i++) {
            int cur = ord_cc[i];

            // 후보가 이미 사진에 올라가있으면
            if (cand_where[cur] != -1) {
                //좋아요만 올려줌
                cand_like[cur]++;
            } else {
                //비어있는 또는 후보를 넣을 사진 위치를 얻음
                int pos = get_pic_frame();
                int delete_cand = pic_frame[pos];

                //사진 내리고 좋아요 초기화
                if (delete_cand != 0) {
                    cand_where[delete_cand] = -1;
                    cand_like[delete_cand] = 0;
                }

                cand_where[cur] = pos;
                cand_like[cur] = 1;
                cand_when[cur] = i;
                pic_frame[pos] = cur;
            }
        }

        //정답 출력
        for(int i=1; i<=100; i++){
            if(cand_where[i] != -1){
                System.out.print(i + " ");
            }
        }

    }

}
