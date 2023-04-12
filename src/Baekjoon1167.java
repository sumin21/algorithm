import java.io.*;
import java.util.*;

class Node1167 {
    int v;
    int c;
    Node1167 ( int v, int c) {
        this.v = v;
        this.c = c;
    }
}
public class Baekjoon1167 {
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int v;
    public static List<Node1167>[] arr;
    public static boolean[] starts;
    public static long max=0;
    public static int maxI;
    public void Baekjoon1167() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        v = Integer.parseInt(br.readLine());
        arr = new ArrayList[v+1];
        starts = new boolean[v+1];
        for (int i=1; i<=v; i++) {
            arr[i] = new ArrayList<>();
        }
        for (int i=0; i<v; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            while(true) {
                int y = Integer.parseInt(st.nextToken());
                if (y == -1) break;
                int c = Integer.parseInt(st.nextToken());
                arr[x].add(new Node1167(y, c));
            }
            if (arr[x].size() == 1) starts[x] = true;
        }
        dfs(1,1,0);

        dfs(maxI, maxI, 0);
        bw.write(String.valueOf(max));
        bw.close();
    }

    public static void dfs(int before, int i, long dist) {
        if (dist != 0 && arr[i].size()==1) {
            if (max < dist) {
                max = dist;
                maxI = i;
            }
        }
        for (Node1167 next : arr[i]) {
            if (next.v == before) continue;
            dfs(i, next.v, dist + next.c);
        }
    }
}
