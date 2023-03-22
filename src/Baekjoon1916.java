import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baekjoon1916 {
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static class Node {
        int v;
        long c;
        Node(int v, long c) {
            this.v = v;
            this.c = c;
        }
    }
    public static int n,m,start,end;
    public static long[] dist;
    public static ArrayList<ArrayList<Node>> nodes = new ArrayList<>();
    public void Baekjoon1916() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        dist = new long[n+1];
        for (int i=0; i<=n; i++) {
            nodes.add(new ArrayList<>());
            dist[i] = Long.MAX_VALUE;
        }

        for (int i=0; i<m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            nodes.get(a).add(new Node(b, c));
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        PriorityQueue<Node> q = new PriorityQueue<>((o1,o2)-> (int) (o1.c - o2.c));
        q.offer(new Node(start,0));
        dist[start] = 0;

        while(!q.isEmpty()) {
            Node now = q.poll();

            if (now.c > dist[now.v]) continue;

            for (int i=0; i<nodes.get(now.v).size(); i++) {
                int next = nodes.get(now.v).get(i).v;
                long nextC = nodes.get(now.v).get(i).c;
                if (dist[next] > dist[now.v]+nextC) {
                    dist[next] = dist[now.v]+nextC;
                    q.offer(new Node(next, dist[next]));
                }
            }
        }

        bw.write(String.valueOf(dist[end]));
        bw.close();

    }
}
