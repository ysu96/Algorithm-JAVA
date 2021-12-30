package Ebay;

public class P4 {
    public int solution(int n, int k, String bulbs) {
        int answer = 0;
        char[] chars = bulbs.toCharArray();
        for(int i=0; i<n; i++){
            char c = chars[i];
            if(c!='R'){
                while (chars[i]!='R'){
                    if(i+k > n){
                        return -1;
                    }
                    for(int j=0; j<k; j++){
                        if(chars[i+j] == 'R'){
                            chars[i+j] = 'G';
                        }else if(chars[i+j] == 'G'){
                            chars[i+j] = 'B';
                        }else{
                            chars[i+j] = 'R';
                        }
                    }
                    answer++;
                }
            }
        }
        System.out.println(answer);
        return answer;
    }

    public static void main(String[] args) {
        P4 p4 = new P4();
        p4.solution(6,3,"RBGRGB");
    }
}
