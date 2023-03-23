import java.io.*;
import java.util.*;

public class Baekjoon2252 {
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int n,m;
    public static int[] depth;
    public static boolean[] visit;
    public static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
    public void Baekjoon2252() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        depth = new int[n+1];
        visit = new boolean[n+1];
        for (int i=0; i<=n; i++) {
            arr.add(new ArrayList<>());
        }
        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            depth[b]++;
            arr.get(a).add(b);
        }

        solution();
    }

    public static void solution() throws IOException{
        Queue<Integer> q = new LinkedList<>();

        for (int i=1; i<=n; i++) {
            if (depth[i] == 0) q.offer(i);
        }
        while (!q.isEmpty()) {
            int student = q.poll();
            if (visit[student]) continue;
            visit[student] = true;
            bw.write(String.valueOf(student)+" ");

            for (int i=0; i<arr.get(student).size(); i++) {
                int next = arr.get(student).get(i);
                depth[next]--;
                if (depth[next]==0) q.offer(next);
            }
        }
        bw.close();

    }
}
