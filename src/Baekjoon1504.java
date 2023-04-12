import java.io.*;
import java.util.*;

class Node {
    int v;
    int cost;
    Node(int v, int cost) {
        this.v = v;
        this.cost = cost;
    }
}
public class Baekjoon1504 {
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int n,e,start, end;
    public static int result = 0;
    public static int[] dist;
    public static int[][] arr;

    public void Baekjoon1504() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        dist = new int[n+1];
        arr = new int[n+1][n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        for (int i=0; i<e; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr[s][e] = c;
            arr[e][s] = c;
        }
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        int r1 = dike(1,start);
        Arrays.fill(dist, Integer.MAX_VALUE);
        int r2 = dike(start,end);
        Arrays.fill(dist, Integer.MAX_VALUE);
        int r3 = dike(end,n);
        Arrays.fill(dist, Integer.MAX_VALUE);
        int r4 = dike(1,end);
        Arrays.fill(dist, Integer.MAX_VALUE);
        int r5 = dike(start,n);
        if (r1==Integer.MAX_VALUE || r2==Integer.MAX_VALUE || r3==Integer.MAX_VALUE ) bw.write("-1");
        else if (r4==Integer.MAX_VALUE || r5==Integer.MAX_VALUE ) bw.write("-1");

        else {
            int result = Math.min(r1+r2+r3, r4+r2+r5);
            bw.write(String.valueOf(result));
        }

        bw.close();

    }

    public static int dike (int startN, int endN) {

        PriorityQueue<Node> heap = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.cost - o2.cost;
            }
        });

        heap.offer(new Node(startN, 0));
        dist[startN] = 0;
        while (!heap.isEmpty()) {
            Node now = heap.poll();

            if (dist[now.v] < now.cost) continue;
            for (int i=1; i<=n; i++) {
                if (arr[now.v][i] != 0) {
                    int next = i;
                    if (dist[next] > arr[now.v][i]+dist[now.v]) {
                        dist[next] = arr[now.v][i]+dist[now.v];
                        heap.offer(new Node(next, dist[next]));
                    }
                }
            }
        }

        return dist[endN];
    }
}
