import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baekjoon2042 {
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int n,m,k;
    public static long[] arr, tree;
    public void Baekjoon2042() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new long[n];
        int height = (int) Math.ceil(Math.log(n) / Math.log(2));
        int treeLen = (int) Math.pow(2, height+1);
        tree = new long[treeLen];

        for (int i=1; i<=n; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }
        init(1, 1, n);
        for (int i=0; i<m+k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a==1) {
                long c = Long.parseLong(st.nextToken());
                update(1, 1, n, b, c-arr[b]);
                arr[b] = c;
            }
            if (a==2) {
                int c = Integer.parseInt(st.nextToken());
                long res = sum(1, 1, n, b, c);
                bw.write(String.valueOf(res));
                bw.newLine();
            }

        }
        bw.close();
    }

    public static long init(int node, int start, int end) {
        if (start==end) {
            return tree[node] = arr[start];
        }
        return tree[node] = init(node*2, start, (start+end)/2) + init(node*2+1, (start+end)/2+1, end);
    }

    public static void update(int node, int start, int end, int idx, long diff) {
        if (idx < start || idx > end) {
            return;
        }

        tree[node] += diff;

        if (start != end) {
            update(node*2, start, (start+end)/2, idx, diff);
            update(node*2+1, (start+end)/2+1, end, idx, diff);
        }
    }

    public static long sum(int node, int start, int end, int left, int right) {
        if (right < start || left > end) return 0;
        if (left <= start && right >= end) return tree[node];
        return
                sum(node*2, start, (start+end)/2, left, right) +
                sum(node*2+1, (start+end)/2+1, end, left, right);
    }
}
