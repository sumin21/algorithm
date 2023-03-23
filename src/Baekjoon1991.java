import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon1991 {
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static class Node{
        char value;
        Node left;
        Node right;
        Node(char value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
    public static int n;
    public static Node root = new Node('A', null, null);
    public static boolean[][] visit;
    public static char[][] arr;
    public static List<Character> alph = new ArrayList<>();
    public void Baekjoon1991() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char p = st.nextToken().charAt(0);
            char l = st.nextToken().charAt(0);
            char r = st.nextToken().charAt(0);
            insertNode(root, p, l, r);
        }
        printTree1(root);
        bw.newLine();
        printTree2(root);
        bw.newLine();
        printTree3(root);
        bw.close();
    }

    public static void insertNode(Node node, char parent, char left, char right) {
        if (node.value == parent) {
            node.left = (left=='.') ? null : new Node(left, null, null);
            node.right = (right=='.') ? null : new Node(right, null, null);
        } else {
            if (node.left != null) insertNode(node.left, parent, left, right);
            if (node.right != null) insertNode(node.right, parent, left, right);
        }
    }

    public static void printTree1(Node node) throws IOException{
        if (node == null) return;
        bw.write(node.value);
        printTree1(node.left);
        printTree1(node.right);
    }

    public static void printTree2(Node node) throws IOException{
        if (node == null) return;
        printTree2(node.left);
        bw.write(node.value);
        printTree2(node.right);
    }

    public static void printTree3(Node node) throws IOException{
        if (node == null) return;
        printTree3(node.left);
        printTree3(node.right);
        bw.write(node.value);
    }
}
