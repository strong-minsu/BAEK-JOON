package Trees;

import java.util.*;
import java.io.*;

//트리 순회
public class p1991 {
    static int N;

    static class Node{
        char data;
        Node left;
        Node right;

        Node(char data, Node left, Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
    static void insertNode(Node temp, char root, char left, char right){
        if(temp.data == root){
            temp.left = (left == '.' ? null : new Node(left, null, null));
            temp.right = (right == '.' ? null : new Node(right, null, null));
        }
        else{
            if(temp.left != null){
                insertNode(temp.left, root, left, right);
            }
            if(temp.right != null){
                insertNode(temp.right, root, left, right);
            }
        }
    }

    static void preOrder(Node node){
        if(node == null){
            return;
        }
        System.out.print(node.data);
        preOrder(node.left);
        preOrder(node.right);
    }

    static void inOrder(Node node){
        if(node == null){
            return;
        }
        inOrder(node.left);
        System.out.print(node.data);
        inOrder(node.right);
    }

    static void postOrder(Node node){
        if(node == null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data);
    }
    static Node startNode = new Node('A', null, null);

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            char root = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            insertNode(startNode, root, left, right);
        }
        preOrder(startNode);
        System.out.println();
        inOrder(startNode);
        System.out.println();
        postOrder(startNode);
        System.out.println();
    }
}
