import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baekjoon13549 {
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static class Node {
        int v;
        long c;
        Node(int v, long c) {
            this.v = v;
            this.c = c;
        }
    }
    public static int n,k;
    public static long[] dist;
    public void Baekjoon13549() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        dist = new long[100001];
        for (int i=0; i<dist.length; i++) {
            dist[i] = Long.MAX_VALUE;
        }

        PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> (int) (o1.c - o2.c));
        q.offer(new Node(n, 0));
        dist[n] = 0;
        while (!q.isEmpty()) {
            Node now = q.poll();
            //if (now.c > dist[now.v]) continue;

            int[] ba = new int[]{now.v - 1, now.v + 1};
            for (int next : ba) {
                if (next >= 0 && next < dist.length) {
                    long nextC = 1;
                    if (dist[next] > dist[now.v] + nextC) {
                        dist[next] = dist[now.v] + nextC;
                        q.offer(new Node(next, dist[next]));
                    }
                }
            }
            if (now.v * 2 < dist.length && dist[now.v * 2] > dist[now.v]) {
                dist[now.v * 2] = dist[now.v];
                q.offer(new Node(now.v * 2, dist[now.v * 2]));
            }
        }
        bw.write(String.valueOf(dist[k]));
        bw.close();

    }

}
