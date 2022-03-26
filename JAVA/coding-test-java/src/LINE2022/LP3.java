package LINE2022;

import java.util.*;

public class LP3 {
    //재택 가능한 업무로만 이루어져 있다면, 그 사원은 재택근무 대상자
    public int[] solution(int num_teams, String[] remote_tasks, String[] office_tasks, String[] employees) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<String, Boolean> remote = new HashMap<>(); //재택 업무 목록
        int[] teamOffice = new int[num_teams + 1]; // 팀 별 출근자 인원 수
        List<Integer>[] teams = new List[num_teams + 1]; // 팀 별 소속된 사원
        
        for (int i = 0; i <= num_teams; i++) {
            teams[i] = new ArrayList<>();
        }

        for (String task : remote_tasks) {
            remote.put(task, true);
        }
        
        //1. 재택 가능 업무만 하는지 확인
        for (int i = 0; i < employees.length; i++) {
            boolean isRemote = true;
            String employee = employees[i];
            String[] split = employee.split(" ");

            int empNum = i + 1;
            int teamNum = Integer.parseInt(split[0]);
            teams[teamNum].add(empNum);

            for (int j = 1; j < split.length; j++) {
                if (!remote.containsKey(split[j])) {
                    //재택 x
                    teamOffice[teamNum]++;
                    isRemote = false;
                    break;
                }
            }
            if (isRemote) answer.add(empNum);
        }

        //2. 팀 별 1명이 있는지 확인
        for(int i=1; i<=num_teams; i++){
            if(teamOffice[i] == 0){
                Collections.sort(teams[i]);
                answer.remove(teams[i].get(0));
                teamOffice[i]++;
            }
        }

        int[] result = new int[answer.size()];
        for(int i=0; i<answer.size(); i++){
            result[i] = answer.get(i);
        }

        return result;
    }

}
