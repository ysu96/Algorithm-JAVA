package LINE2022;

import java.util.*;

//candidate 후보 구하는 과정은 while문에서 빼도 될거같음
// 펜딩리스트에 새로 들어가는건 없을테니깐
public class LP6 {
    class Pending{
        boolean isPurchase;
        int no;
        String name;
        int amount;
        int price;

        Pending(boolean isPurchase, int no, String name, int amount, int price) {
            this.isPurchase = isPurchase;
            this.no = no;
            this.name = name;
            this.amount = amount;
            this.price = price;
        }
    }

    class User{
        String name;
        int gold;
        int silver;

        User(String name, int gold, int silver) {
            this.name = name;
            this.gold = gold;
            this.silver = silver;
        }
    }

    public String[] solution(String[] req_id, int[][] req_info) {
        List<Pending> pendingList = new ArrayList<>(); //pending 목록
        HashMap<String, User> result = new HashMap(); //결과 기록
        for (String s : req_id) {
            result.put(s, new User(s, 0, 0));
        }

        for (int i =0; i< req_info.length; i++) {
            int[] req = req_info[i];
            boolean isPurchase = (req[0] == 0);
            int amount = req[1];
            int price = req[2];
            String name = req_id[i];

            while(true){
                //거래 후보 찾기
                List<Pending> candidate = new ArrayList<>();
                for (int j=0; j<pendingList.size(); j++) {
                    Pending p = pendingList.get(j);
                    if (p.isPurchase == isPurchase) continue;
                    if(!isPurchase && p.price < price) continue; //판매인데 사는 값이 더 낮으면 안팔아
                    if(isPurchase && p.price > price) continue; // 구매인데 파는값이 더 높으면 안사
                    candidate.add(p);
                }

                // 후보가 있으면
                if(candidate.size() > 0){
                    if(!isPurchase){
                        //판매일땐 구매가격 비싼 순서대로 정렬
                        Collections.sort(candidate, new Comparator<Pending>() {
                            @Override
                            public int compare(Pending o1, Pending o2) {
                                if(o1.price > o2.price) return -1;
                                else if(o1.price == o2.price){
                                    if(o1.no < o2.no) return -1;
                                    else return 1;
                                }else{
                                    return 1;
                                }
                            }
                        });
                    }else{
                        // 구매일땐 판매가격 싼 순서대로 정렬
                        Collections.sort(candidate, new Comparator<Pending>() {
                            @Override
                            public int compare(Pending o1, Pending o2) {
                                if(o1.price < o2.price) return -1;
                                else if(o1.price == o2.price){
                                    if(o1.no < o2.no) return -1;
                                    else return 1;
                                }else{
                                    return 1;
                                }
                            }
                        });
                    }

                    //거래 진행
                    Pending cur = candidate.get(0);
                    User seller;
                    User purchaser;
                    int totalAmount, totalPrice;

                    if(!isPurchase){ //판매
                        totalAmount = Math.min(cur.amount, amount);
                        totalPrice = totalAmount * price;

                        seller = result.get(name);
                        purchaser = result.get(cur.name);

                        // 판매자 -> 구매자 totalamount 골드 이동
                        seller.gold -= totalAmount;
                        purchaser.gold += totalAmount;
                        // 구매자 -> 판매자 totalprice 실버 이동
                        purchaser.silver -= totalPrice;
                        seller.silver += totalPrice;

                        result.put(name, seller);
                        result.put(cur.name, purchaser);
                    }
                    else{ // 구매
                        totalAmount = Math.min(cur.amount, amount);
                        totalPrice = totalAmount * cur.price;

                        purchaser = result.get(name);
                        seller = result.get(cur.name);

                        // 판매자 -> 구매자 totalamount 골드 이동
                        seller.gold -= totalAmount;
                        purchaser.gold += totalAmount;
                        // 구매자 -> 판매자 totalprice 실버 이동
                        purchaser.silver -= totalPrice;
                        seller.silver += totalPrice;

                        result.put(name, purchaser);
                        result.put(cur.name, seller);
                    }

                    cur.amount -= totalAmount;
                    if(cur.amount <= 0) pendingList.remove(cur); //done

                    amount -= totalAmount;
                    if(amount <= 0) break; //done

                }else{
                    // 거래 못함, pending 등록
                    pendingList.add(new Pending(isPurchase, i, name, amount, price));
                    break;
                }
            }
        }

        String[] answer = makeAnswer(req_id, result);
        return answer;
    }

    public String[] makeAnswer(String[] req_id, HashMap<String, User> result){
        Arrays.sort(req_id);
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>(Arrays.asList(req_id));
        String[] idSet = linkedHashSet.toArray(new String[0]);
        String[] answer = new String[idSet.length];
        for (int i=0; i<idSet.length; i++) {
            User user = result.get(idSet[i]);

            StringBuilder sb = new StringBuilder();
            sb.append(user.name).append(" ");
            if(user.gold > 0) sb.append("+");
            sb.append(user.gold).append(" ");

            if(user.silver > 0) sb.append("+");
            sb.append(user.silver);

            answer[i] = sb.toString();
        }
        return answer;
    }

    public static void main(String[] args) {
        LP6 lp6 = new LP6();
        String[] req_id = {"William", "Andy", "Rohan", "Rohan", "Louis", "Andy"};
        int[][] req_info = {{1, 7, 20}, {0, 10, 10}, {1, 10, 40}, {1, 4, 25}, {0, 5, 11}, {0, 20, 30}};
        String[] solution = lp6.solution(req_id, req_info);
        for(String s : solution){
            System.out.println(s);
        }
    }
}
