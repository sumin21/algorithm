import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon2357 {
    public static int n,m;
    public static int[] arr, tree, tree2;
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public void Baekjoon2357() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n+1];
        int high  = (int) Math.ceil(Math.log(n+1) / Math.log(2));
        int treeLen = (int) Math.pow(2, high+1);
        tree = new int[treeLen];
        tree2 = new int[treeLen];
        for (int i = 0; i < n; i++) {
            arr[i+1] = Integer.parseInt(br.readLine());
        }
        init(1,1,n);
        init2(1,1,n);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int res = getMax(1, 1, n, a, b);
            int res2 = getMin(1, 1, n, a, b);
            bw.write(String.valueOf(res2) + " " + String.valueOf(res));
            bw.newLine();
        }
        bw.close();
    }

    public static int init(int node, int start, int end) {
        if (start == end) {
            return tree[node] = arr[start];
        }
        return tree[node] = Math.max(init(node*2, start, (start+end)/2), init(node*2+1,(start+end)/2+1, end));
    }

    public static int getMax(int node, int start, int end, int left, int right) {
        if (left > end || right < start) return 0;
        if (left <= start && right >= end) return tree[node];
        return Math.max(getMax(node*2, start, (start+end)/2, left, right),getMax(node*2+1, (start+end)/2+1, end, left, right) );
    }

    public static int init2(int node, int start, int end) {
        if (start == end) {
            return tree2[node] = arr[start];
        }
        return tree2[node] = Math.min(init2(node*2, start, (start+end)/2), init2(node*2+1,(start+end)/2+1, end));
    }

    public static int getMin(int node, int start, int end, int left, int right) {
        if (left > end || right < start) return Integer.MAX_VALUE;
        if (left <= start && right >= end) return tree2[node];
        return Math.min(getMin(node*2, start, (start+end)/2, left, right),getMin(node*2+1, (start+end)/2+1, end, left, right) );
    }
}
