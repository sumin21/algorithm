import java.io.*;
import java.util.*;


class Node1865{
    int s;
    int e;
    int c;
    Node1865(int s, int e, int c) {
        this.s = s;
        this.e = e;
        this.c = c;
    }
}
public class Baekjoon1865 {
    public static int t, n,m,w;
    public static int result = 0;
    public static int[] dist;
    public static List<Node1865> arr = new ArrayList<>();
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public void Baekjoon1865() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        for (int i=0; i<t; i++) {
            result = 0;
            arr.clear();
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            dist = new int[n+1];

            for (int j=0; j<m; j++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                arr.add(new Node1865(s,e,c));
                arr.add(new Node1865(e,s,c));
            }
            for (int j=0; j<w; j++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                arr.add(new Node1865(s,e,-1 * c));
            }

            for (int j=0; j<n; j++) {
                if (belman(j+1)) {
                    result = 1;
                    break;
                }
            }

            bw.write(result==1 ? "YES" : "NO");
            bw.newLine();
        }

        bw.close();

    }

    public static boolean belman(int start) {
        int size = arr.size();
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        boolean update = false;
        for (int i=0; i<n; i++) {
            update = false;
            for (int j=0; j<size; j++) {
                Node1865 n = arr.get(j);
                if (dist[n.s] != Integer.MAX_VALUE && dist[n.e] > dist[n.s]+n.c) {
                    dist[n.e] = dist[n.s]+n.c;
                    update = true;
                }
            }
            if (!update) {
                break;
            }
        }

        for (int j=0; j<size; j++) {
            Node1865 n = arr.get(j);
            if (dist[n.s] != Integer.MAX_VALUE && dist[n.e] > dist[n.s]+n.c) {
                return true;
            }
        }
        return false;
    }
}
