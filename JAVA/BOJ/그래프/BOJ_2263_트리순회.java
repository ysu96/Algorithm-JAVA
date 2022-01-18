package JAVA.BOJ.그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2263_트리순회 {
    public static int n;
    public static int[] inorder, postorder;
    public static List<Integer> preorder = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        inorder = new int[n];
        postorder = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            inorder[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            postorder[i] = Integer.parseInt(st.nextToken());
        }

        divideconquer(0, n - 1, 0, n - 1);
        for (int i : preorder) {
            System.out.print(i);
            System.out.print(" ");
        }
    }

    public static void divideconquer(int inFirst, int inLast, int postFirst, int postLast) {
        if (inFirst > inLast || postFirst > postLast) return;

        int root = postorder[postLast];
        preorder.add(root);

        int rootIdx = 0;
        for (int i = 0; i < n; i++) {
            if (inorder[i] == root) {
                rootIdx = i;
                break;
            }
        }
        //왼쪽 자식 개수
        int left = rootIdx - inFirst;
        divideconquer(inFirst, rootIdx - 1, postFirst, postFirst + left - 1);
        divideconquer(rootIdx + 1, inLast, postFirst + left, postLast - 1);
    }

}
