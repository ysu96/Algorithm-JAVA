package 네이버파이낸셜;

import java.util.*;

public class NF2 {
    // 양방향
    // 최대 적재 무게, 이용 요금
    // Map<city, 연결된 도시들?>
    // Map<city, 가지고 있는 차량>


    // 도시 별 최단 거리를 미리 구해놓고 거기다 차 비용값만 곱하면 되는구나..
    // 택시 찾을 때 이분탐색?
    class Car{
        int weight;
        int price;

        Car(int weight, int price) {
            this.weight = weight;
            this.price = price;
        }
    }

    Map<String, Integer> cityIdx = new HashMap<>();
    int[][] cityConnections;
    List<Car>[] cityCars;

    public String[] solution(String[] cities, String[] roads, String[] cars, String[] customers) {
        int idx = 0;
        Arrays.sort(cities);
        for (String c : cities) {
            cityIdx.put(c, idx++);
        }

        cityConnections = new int[cities.length][cities.length];
        cityCars = new List[cities.length];
        for(int i =0; i<cities.length; i++){
            cityCars[i] = new ArrayList();
        }
        
        for (String r : roads) {
            String[] split = r.split(" ");
            String from = split[0];
            String to = split[1];
            int dist = Integer.parseInt(split[2]);
            cityConnections[cityIdx.get(from)][cityIdx.get(to)] = dist;
            cityConnections[cityIdx.get(to)][cityIdx.get(from)] = dist;
        }

        for(String car : cars){
            String[] split = car.split(" ");
            int city = cityIdx.get(split[0]);
            int weight = Integer.parseInt(split[1]);
            int price = Integer.parseInt(split[2]);
            cityCars[city].add(new Car(weight, price));
        }

        /*
        이부분 추가헀으면 좋았을텐데
         */
        for (List cityCar : cityCars) {
            cityCar.sort(new Comparator<Car>() { // 무게 적은 순으로 정렬
                @Override
                public int compare(Car o1, Car o2) {
                    if (o1.weight < o2.weight) {
                        return -1;
                    }
                    else{
                        return 1;
                    }
                }
            });
        }

        List<String> answer = new ArrayList<>();
        for (String customer : customers) {
            String[] split = customer.split(" ");
            int start = cityIdx.get(split[0]);
            int dest = cityIdx.get(split[1]);
            int bag = Integer.parseInt(split[2]);
            
            // 찾기
            int city = findStartCity(start, dest, bag);
            answer.add(cities[city]);
        }
        for(String s : answer){
            System.out.println(s);
        }
        return  answer.toArray(new String[answer.size()]);
    }

    public int findStartCity(int start, int dest, int bag){
        int minPrice = Integer.MAX_VALUE;
        int minCity = Integer.MAX_VALUE;

        // 모든 도시에서 출발해보기??
        // 각 도시에서 start까지 가고 거기서 또 dest까지 가는 비용 구해보기
        int len = cityConnections.length;
        for(int i = 0; i < len; i++){
            Car myCar = null;
            List<Car> cityCar = cityCars[i];
//
//            cityCar.sort(new Comparator<Car>() { // 무게 적은 순으로 정렬
//                @Override
//                public int compare(Car o1, Car o2) {
//                    if (o1.weight < o2.weight) {
//                        return -1;
//                    }
//                    else{
//                        return 1;
//                    }
//                }
//            });

            boolean findCar = false;
            for (Car c : cityCar) {
                if(c.weight >= bag){
                    myCar = c; // 무게 맞추기
                    findCar = true;
                    break;
                }
            }
            if(!findCar) continue;

            int total;
            if(i == start){
                total = find(myCar, i, dest);
            }else{
                // 다른 도시에서 일단 start까지 차 옮겨야함
                total = find(myCar, i, start) + find(myCar, start, dest);
            }

            if(total < minPrice){
                minCity = i;
                minPrice = total;
            } else if (total == minPrice && minCity > i) {
                minCity = i;
            }
        }


        return minCity;
    }

    public int find(Car car, int start, int dest){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        int[] prices = new int[cityConnections.length];
        Arrays.fill(prices, 200000);
        prices[start] = 0;

        while (!q.isEmpty()){
            int curCity = q.poll();

            for(int i=0; i<cityConnections.length; i++){
                int dist = cityConnections[curCity][i];
                if(dist == 0) continue; // 길 없음
                int price = dist * car.price;

                if (price + prices[curCity] < prices[i]) {
                    prices[i] = price + prices[curCity];
                    q.add(i);
                }
            }

        }
        return prices[dest];
    }

    public static void main(String[] args) {
        NF2 nf2 = new NF2();
        String[] cities = {"a","b","c","d","e","f","g"};
        String[] roads = {"a b 1","a c 1","c d 3","b d 5","b e 6","d e 2","f g 8"};
        String[] cars = {"a 100 10","a 200 15","b 100 5","c 20 2","c 300 30","d 200 20","e 500 100","f 500 50","g 100 40"};
        String[] cus = {"g f 200","c e 50","d a 500","a b 50"};
        nf2.solution(cities, roads, cars, cus);
    }
}
