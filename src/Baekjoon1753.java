import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baekjoon1753 {
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static class Node {
        int v;
        int cost;

        Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }
    public static int v,e,start;
    public static int[] dist;
    public static ArrayList<ArrayList<Node>> nodes = new ArrayList<>();
    public void Baekjoon1753() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(br.readLine());

        dist = new int[v+1];
        for (int i=0; i<=v; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        for (int i=0; i<=v; i++) {
            nodes.add(new ArrayList<>());
        }
        for (int i=0; i<e; i++) {
            st = new StringTokenizer(br.readLine());
            int i1 = Integer.parseInt(st.nextToken());
            int i2 = Integer.parseInt(st.nextToken());
            int i3 = Integer.parseInt(st.nextToken());
            nodes.get(i1).add(new Node(i2, i3));
        }

        PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        q.offer(new Node(start, 0));
        dist[start] = 0;
        while (!q.isEmpty()) {
            Node nowN = q.poll();

            if (nowN.cost > dist[nowN.v]) {
                continue;
            }

            for (int i=0; i<nodes.get(nowN.v).size(); i++) {
                int nextN = nodes.get(nowN.v).get(i).v;
                int nextNCost = nodes.get(nowN.v).get(i).cost;
                if (dist[nextN] > nextNCost+dist[nowN.v]) {
                    dist[nextN] = nextNCost+dist[nowN.v]; //dist update
                    q.offer(new Node(nextN, dist[nextN]));
                }

            }
        }

        for (int i=1; i<=v; i++) {
            bw.write((dist[i] == Integer.MAX_VALUE) ? "INF" : String.valueOf(dist[i]));
            bw.newLine();
        }
        bw.close();
    }
}
