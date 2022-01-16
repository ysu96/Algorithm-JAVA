package Wins;

public class P2 {
    public int solution(String skill, String[] skill_trees){
        int answer = 0;

        for (String st : skill_trees) {
            int lastSkill = 0;
            boolean isOk = true;
            boolean[] learned = new boolean[skill.length()];

            for(int i=0; i<st.length(); i++){
                char cur = st.charAt(i);
                int idx = checkIdx(cur, skill);

                if(idx == -1) continue;

                for(int j=0; j<idx; j++){
                    if (!learned[j]) {
                        isOk = false;
                        break;
                    }
                }

                if(!isOk) break;
                learned[idx] = true;
            }
            if(isOk) answer++;
        }
        return answer;
    }

    public int checkIdx(char c, String skill){
        for(int i=0; i<skill.length(); i++){
            if (skill.charAt(i) == c) {
                return i;
            }
        }
        return -1;
    }
}
