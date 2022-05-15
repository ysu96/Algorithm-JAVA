package 네이버파이낸셜;

public class NF3 {
}

// 구간별로 용량 채우기
// 내리는 정류장 순서로 오름차순 정렬
// 그리디 하게 앞에서부터 용량 다 빼줌

//import sys
//si = sys.stdin.readline
//n_station, n_taxi, n_customer = map(int, si().split())
//capacities = [0 for _ in range(n_station + 1)]
//for _ in range(n_taxi):
//    x, y, capacity = map(int, si().split())
//    for i in range(x, y):
//        capacities[i] += capacity
//customers = [tuple(map(int, si().split())) for _ in range(n_customer)]
//customers.sort(key=lambda x: x[1])
//ans = 0
//for start, goal in customers:
//    flag = True
//    for i in range(start, goal):
//        if capacities[i] == 0:
//            flag = False
//            break
//    if flag:
//        for i in range(start, goal):
//            capacities[i] -= 1
//        ans += 1
//print(ans)
