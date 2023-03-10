import java.io.*;
import java.util.*;

public class Baekjoon1260 {
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int n,m,v;
    public static int[][] arr;
    public static boolean[] visit;
    public void Baekjoon1260() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        visit = new boolean[n];

        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a-1][b-1] = 1;
            arr[b-1][a-1] = 1;
        }
        dfs(v-1);
        bw.newLine();
        visit = new boolean[n];
        bfs(v-1);
        bw.close();
    }

    public static void dfs(int idx) throws IOException{
        bw.write(String.valueOf(idx+1)+" ");
        visit[idx] = true;

        for (int i=0; i<n; i++) {
            if (arr[idx][i] == 1 && visit[i] == false) {
                dfs(i);
            }
        }
    }

    public static void bfs(int idx) throws IOException{
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(idx);
        visit[idx] = true;

        while (!queue.isEmpty()) {
            int i = queue.poll();
            bw.write(String.valueOf(i+1)+" ");

            for (int j=0; j<n; j++) {
                if (arr[i][j] == 1 && visit[j] == false) {
                    queue.offer(j);
                    visit[j] = true;
                }
            }
        }
    }
}
