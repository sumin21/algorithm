import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon11404 {
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
    public static long[][] dist;

    public void Baekjoon11404() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        dist = new long[n+1][n+1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (i==j) dist[i][j] = 0;
                else dist[i][j] = Long.MAX_VALUE;
            }
        }
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges.add(new Edge(a, b, c));
            if (dist[a][b] != Long.MAX_VALUE) dist[a][b] = Math.min(c, dist[a][b]);
            else dist[a][b] = c;
        }
        ploid();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (dist[i][j] == Long.MAX_VALUE) bw.write("0 ");
                else bw.write(String.valueOf(dist[i][j])+" ");
            }
            bw.newLine();
        }
        bw.close();
    }

    public static void ploid() {
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=n; j++) {
                for (int k = 1; k <= n; k++) {
                    if (dist[j][i] != Long.MAX_VALUE && dist[i][k] != Long.MAX_VALUE && dist[j][k] > dist[j][i]+dist[i][k]) {
                        dist[j][k] = dist[j][i]+dist[i][k];
                    }
                }
            }
        }
    }
}
