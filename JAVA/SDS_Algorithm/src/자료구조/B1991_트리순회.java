package 자료구조;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Node{
    char data;
    Node left;
    Node right;
    Node(char data){
        this.data = data;
    }
}
class Tree{
    Node root;

    public void createNode(char data, char leftData, char rightData){
        if(root == null){
            root = new Node(data);
            if (leftData != '.') {
                root.left = new Node(leftData);
            }
            if (rightData != '.') {
                root.right = new Node(rightData);
            }
        }
        else{
            searchNode(root, data, leftData, rightData);
        }
    }

    public void searchNode(Node root, char data, char leftData, char rightData){
        if(root == null) return;
        else if(root.data == data){
            if (leftData != '.') {
                root.left = new Node(leftData);
            }
            if (rightData != '.') {
                root.right = new Node(rightData);
            }
        }
        else{
            searchNode(root.left, data, leftData, rightData);
            searchNode(root.right, data, leftData, rightData);
        }
    }

    public void preorder(Node root){
        System.out.print(root.data);
        if(root.left != null) preorder(root.left);
        if (root.right != null) preorder(root.right);
    }

    public void inorder(Node root){
        if(root.left != null) inorder(root.left);
        System.out.print(root.data);
        if (root.right != null) inorder(root.right);
    }

    public void postorder(Node root){
        if(root.left != null) postorder(root.left);
        if (root.right != null) postorder(root.right);
        System.out.print(root.data);
    }
}

public class B1991_트리순회 {
    private static int N;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Tree tree = new Tree();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            char root = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);
            tree.createNode(root, left, right);
        }

        tree.preorder(tree.root);
        System.out.println();
        tree.inorder(tree.root);
        System.out.println();
        tree.postorder(tree.root);
    }
}
