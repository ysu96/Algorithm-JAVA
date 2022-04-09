package 오늘의집;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

//3 ≤ path의 길이 ≤ 100
//path는 E, W, S, N으로만 구성된 문자열입니다.
//E와 W가 서로 붙어있는 경우는 없습니다.
//S와 N가 서로 붙어있는 경우는 없습니다.
public class Bucketplace1 {

    public String getDirection(char prev, char cur){
        if(prev == 'W'){
            if(cur == 'N') return "right";
            else return "left";
        }else if(prev == 'E'){
            if(cur == 'N') return  "left";
            else return "right";
        }else if(prev == 'N'){
            if(cur == 'W') return  "left";
            else return "right";
        }else{
            if(cur == 'E') return  "left";
            else return  "right";
        }
    }

    public String[] solution(String path){
        List<String> list = new ArrayList<>();
        int time = 0;
        int distance = 0;
        String direction = "";
        char DIR = path.charAt(0);

        for(int i=0; i<path.length(); i++){
            char c = path.charAt(i);
            if(c == DIR){
                distance += 100;
                time++;
            }else{
                direction = getDirection(DIR, c);

                String result = "";
                if(distance <= 500){
                    result = String.format("Time %d: Go straight %dm and turn %s", time-(distance/100), distance, direction);
                }else{
                    result = String.format("Time %d: Go straight %dm and turn %s", time-5, 500, direction);
                }

                list.add(result);

                distance = 100;
                time++;
                DIR = c;
            }
        }
//        String result = String.format("Time %d: Go straight %dm and turn %s", time, distance, direction);
//        list.add(result);

        String[] answer = new String[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        Bucketplace1 bc = new Bucketplace1();
        String[] strings = bc.solution("EESE");
        for (String s : strings) {
            System.out.println(s);
        }
        //"EEESEEEEEENNNN"	["Time 0: Go straight 300m and turn right","Time 3: Go straight 100m and turn left","Time 5: Go straight 500m and turn left"]
        //"SSSSSSWWWNNNNNN"	["Time 1: Go straight 500m and turn right","Time 6: Go straight 300m and turn right"]
    }
}
