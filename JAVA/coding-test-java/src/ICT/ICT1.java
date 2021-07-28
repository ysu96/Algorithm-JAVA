package ICT;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ICT1 {
    static int maxTickets(List<Integer> tickets){
        Collections.sort(tickets);
        int max = 1;
        List<Integer> cand = new ArrayList<Integer>();

        if(tickets.size() == 1){
            return 1;
        }

        for(int i=1; i<tickets.size(); i++){
            if(tickets.get(i) - tickets.get(i-1) <= 1){
                max++;
                if(i == tickets.size()-1) cand.add(max);
            }
            else{
                cand.add(max);
                max = 0;
            }
        }
        return Collections.max(cand);
    }
}
