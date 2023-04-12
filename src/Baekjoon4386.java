import java.io.*;
import java.util.*;

class Edge4386{
    int v;
    int w;
    double c;
    Edge4386(int v, int w, double c) {
        this.v=v;
        this.w=w;
        this.c=c;
    }
}
public class Baekjoon4386 {
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static int n;
    public static int[] parents;
    public static double[][] arr;
    public static List<Edge4386> edges = new ArrayList<>();
    public static double result = 0;

    public void Baekjoon4386() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        parents = new int[n];
        arr = new double[n][2];
        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());
            arr[i][0] = x;
            arr[i][1] = y;
            parents[i] = i;
        }

        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++) {

                double dist = Math.sqrt(Math.pow(arr[i][0] - arr[j][0], 2) + Math.pow(arr[i][1] - arr[j][1], 2));
                edges.add(new Edge4386(i,j,dist));
            }
        }
        Collections.sort(edges, new Comparator<Edge4386>() {
            @Override
            public int compare(Edge4386 o1, Edge4386 o2) {
                return (int) (o1.c - o2.c);
            }
        });

        spanning();
        bw.write(String.valueOf(result));

        bw.close();
    }

    public static void spanning() {
        while (edges.size() > 0) {
            Edge4386 e = edges.get(0);

            if (findP(e.v) != findP(e.w)) {
                result += e.c;
                union(e.v, e.w);
            }
            edges.remove(0);
        }
    }

    public static int findP(int x) {
        if (x == parents[x]) return x;
        else return parents[x] = findP(parents[x]);
    }

    public static void union(int x, int y) {
        int xP = findP(x);
        int yP = findP(y);
        parents[xP] = Math.min(xP, yP);
        parents[yP] = Math.min(xP, yP);
    }



}


