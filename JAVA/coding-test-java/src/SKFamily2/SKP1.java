package SKFamily2;

import java.util.*;

public class SKP1 {
    public String[] solution(String[] goods) {
        List<String> ans = new ArrayList<>();

        for (String good : goods) {
            Map<String, Boolean> check = new HashMap<>();
            List<String> list = new ArrayList<>();
            int len = 1;
            boolean find = false;

            while(len <= good.length()){
                for(int i=0; i<=good.length()-len; i++){
                    String s = good.substring(i, i + len);

                    if(check.containsKey(s)) continue;
                    else check.put(s, true);

                    int cnt = 0;
                    for (String tmp : goods) {
                        if(tmp.contains(s)){
                            cnt++;
                        }
                    }

                    if(cnt == 1){
                        list.add(s);
                        find = true;
                    }
                }
                if(find) break;
                len++;
            }

            if(list.size() == 0) ans.add("None");
            else{
                Collections.sort(list);
                StringBuilder sb = new StringBuilder();
                for(String s : list){
                    sb.append(s).append(" ");
                }
                sb.deleteCharAt(sb.length()-1);
                ans.add(sb.toString());
            }
        }

        String[] answer = new String[ans.size()];
        for(int i=0; i<ans.size(); i++){
            answer[i] = ans.get(i);
        }
        return answer;
    }
}
