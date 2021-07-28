//package 시간복잡도;
//
//public class B2805_나무자르기 {
//}
//
//#include <cstdio>
//
//typedef long long LL;
//
//        int n, m;
//        LL tree[1000000];
//        LL answer;
//
//        bool cutok(LL h) {
//        LL sum = 0;
//        for (int i = 0 ; i < n ; i++) {
//        if (tree[i] > h) {
//        sum += tree[i] - h;
//        }
//        if (sum >= m) return true;
//        }
//        return false;
//        }
//
//        int main() {
//        scanf("%d%d", &n, &m);
//        for (int i = 0 ; i < n ; i++) {
//        scanf("%lld", &tree[i]);
//        }
//        // 높이를 변경해가면서 나무를 잘라보고
//        // 조건을 만족하는 가장 큰 높이를 찾아본다.....
//        // 시간 초과가 발생할 것 같음
//    /*
//    for (LL h = 0 ; h <= 1000000000 ; h++) {
//        if (cutok(h)) {
//            answer = h;
//        }
//        else {
//            break;
//        }
//    }
//    */
//        LL bottom = 0, top = 1000000000, mid;
//        while (bottom <= top) {
//        mid = (bottom + top) / 2;
//        if (cutok(mid)) {
//        if (answer < mid) answer = mid;
//        bottom = mid + 1;
//        }
//        else {
//        top = mid - 1;
//        }
//        }
//        printf("%lld", answer);
//        }