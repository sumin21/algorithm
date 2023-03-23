import java.io.*;
import java.util.*;

public class Baekjoon1197 {
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static class Edge{
        int v;
        int w;
        int c;
        Edge(int v, int w, int c) {
            this.v=v;
            this.w=w;
            this.c=c;
        }
    }
    public static int v,e;
    public static int[] parents;
    public static List<Edge> edges = new ArrayList<>();
    public static int result = 0;
    public void Baekjoon1197() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        parents = new int[v+1];
        for (int i=0; i<=v; i++) {
            parents[i] = i;
        }
        for (int i=0; i<e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges.add(new Edge(a,b,c));

        }
        Collections.sort(edges, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.c-o2.c;
            }
        });
        mst();
        bw.write(String.valueOf(result));
        bw.close();
    }

    public static void mst() {
        while (edges.size() > 0) {
            Edge e = edges.get(0);
            if (findP(e.v) != findP(e.w)) {
                // cycle X
                union(e.v, e.w);
                result += e.c;
            }
            edges.remove(0);
        }
    }

    public static void union(int a, int b) {
        int ap = findP(a);
        int bp = findP(b);
        if (ap <= bp) parents[bp] = ap;
        else parents[ap] = bp;
    }

    public static int findP(int e) {
        if (e == parents[e]) return e;
        return findP(parents[e]);
    }

}
