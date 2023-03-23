import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon11657 {
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static class Edge {
        int v;
        int w;
        int c;
        Edge (int v, int w, int c) {
            this.v = v;
            this.w = w;
            this.c = c;
        }
    }
    public static int n,m;
    public static ArrayList<Edge> edges = new ArrayList<>();
    public static long[] dist;

    public void Baekjoon11657() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        dist = new long[n+1];

        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges.add(new Edge(a,b,c));
        }

        boolean bool = calDist();
        if (!bool) bw.write("-1");
        else {
            for (int i=2; i< dist.length; i++) {
                bw.write((dist[i] == Long.MAX_VALUE) ? "-1" : String.valueOf(dist[i]));
                bw.newLine();
            }
        }
        bw.close();
    }

    public static boolean calDist() {
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[1] = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                Edge e = edges.get(j);
                if (dist[e.w] > dist[e.v] + e.c && dist[e.v] != Long.MAX_VALUE) {
                    dist[e.w] = dist[e.v] + e.c;

                }
            }
        }
        for (int j=0; j<m; j++) {
            Edge e = edges.get(j);
            if (dist[e.w] > dist[e.v] + e.c && dist[e.v] != Long.MAX_VALUE) {
                return false;
            }
        }

        return true;
    }
}
