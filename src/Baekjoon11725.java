import java.io.*;
import java.util.*;

public class Baekjoon11725 {
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static int n;
    public static List<Integer>[] arr;
    public static int[] parents;
    public static double result = 0;

    public void Baekjoon11725() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        parents = new int[n+1];
        arr = new ArrayList[n+1];
        for (int i=1; i<=n; i++) {
            arr[i] = new ArrayList<>();
        }
        for (int i=0; i<n-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x].add(y);
            arr[y].add(x);
        }

        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        while (!q.isEmpty()) {
            int node = q.poll();
            for (int child : arr[node]) {
                if (child != parents[node]) {
                    parents[child] = node;
                    q.offer(child);
                }
            }
        }
        for (int i=2; i<=n; i++) {
            bw.write(String.valueOf(parents[i]));
            bw.newLine();
        }
        bw.close();
    }
}
