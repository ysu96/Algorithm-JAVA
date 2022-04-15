package LINE2022;

import java.util.*;

public class LP3 {
    //재택 가능한 업무로만 이루어져 있다면, 그 사원은 재택근무 대상자
    public int[] solution(int num_teams, String[] remote_tasks, String[] office_tasks, String[] employees) {
        ArrayList<Integer> answer = new ArrayList<>();
        // answer를 리스트로 하지말고
        // boolean[] answer = new boolean[사원수] 로 하고
        // 출근하는 사람들 true로 바꿔주면 될듯
        // 그리고 팀 별 가장 빠른 사번 기록해서 팀 출근자 0명이면 빠른 사번 출근 true로 바꿔주고
        // 정답 출력할땐 false인 사람만 리턴하도록
        
        // 이렇게 하면 팀 별 출근자 1명 있는지 확인할때 메모리도 아끼고 정답에서 remove하는 시간을 아낅 수 있음

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
                Collections.sort(teams[i]); // 이건 필요 없었을듯 어차피 낮은 순으로 들어오니깐

                // 그냥 애초에 팀별로 가장 빠른 사번인 사람 한명씩 기록해두고 출근자 0명인 팀은 그사람 출근시키면 될듯
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
