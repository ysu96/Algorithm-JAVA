package Level1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Player{
    int no;
    int weight;
    double winRate;
    int overweight;

    public Player(int no, int weight, double winRate, int overweight) {
        this.no = no;
        this.weight = weight;
        this.winRate = winRate;
        this.overweight = overweight;
    }
}

public class 복서정렬하기 {
    public int[] solution(int[] weights, String[] head2head) {
        int[] answer = new int[weights.length];
        List<Player> players = new ArrayList<>();
        // 1. 전체 승률 / 아직 다른 복서랑 붙어본 적이 없는 복서의 승률은 0%로 취급합니다.
        //2. 자신보다 몸무게가 무거운 복서를 이긴 횟수가 많은 복서의 번호가 앞쪽으로 갑니다.
        //3. 자기 몸무게가 무거운 복서의 번호가 앞쪽으로 갑니다.
        //4. 작은 번호가 앞쪽으로 갑니다.
        for(int i=0; i<weights.length; i++){
            int no = i+1;
            int weight = weights[i];
            double winRate = 0;
            int overweight = 0;

            int win=0, lose=0;
            for(int j=0; j< head2head[i].length(); j++){
                if(head2head[i].charAt(j) == 'W'){
                   win++;
                   if(weights[i] < weights[j]) overweight++;

                }else if(head2head[i].charAt(j) == 'L'){
                    lose++;
                }
            }
            winRate = (double) win / (win+lose);
            players.add(new Player(no, weight, winRate, overweight));
        }

        Collections.sort(players, new Comparator<Player>() {
            @Override
            public int compare(Player p1, Player p2) {
                // 승률 내림차순
                if(p1.winRate > p2.winRate) return -1;
                else if(p1.winRate < p2.winRate) return 1;
                else { // 승률 같다면, 체급 차 승리 수 내림차순
                    if(p1.overweight > p2.overweight) return -1;
                    else if(p1.overweight < p2.overweight) return 1;
                    else { // 같다면, 몸무게 내림차순
                        if(p1.weight > p2.weight) return -1;
                        else if(p1.weight < p2.weight) return 1;
                        else { // 같다면, 번호(이름) 오름차순
                            if(p1.no > p2.no) return 1;
                            else if(p1.no < p2.no) return -1;
                        }
                    }
                }
                return 0;
            }
        });

        for (int i = 0; i < weights.length; i++) {
            answer[i] = players.get(i).no;
        }
        return answer;
    }
}
