import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon1012 {
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int t, m, n, k;
    public static int arr[][];
    public static int result = 0;
    public void Baekjoon1012() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            arr = new int[n][m];
            result = 0;
            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                arr[x][y] = 1;
            }
            for (int j = 0; j < n; j++) {
                for (int l =0; l<m; l++) {
                    if (arr[j][l]==1) {
                        bfs(j,l);
                        result+=1;
                    }
                }
            }
            bw.write(String.valueOf(result));
            bw.newLine();
        }

        bw.close();
    }

    public static void bfs(int sx, int sy) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {sx,sy});
        while (!q.isEmpty()) {
            int[] point = q.poll();
//            arr[point[0]][point[1]] = 2;
            if (point[0]-1 >=0 && arr[point[0]-1][point[1]]==1) {
                arr[point[0]-1][point[1]] = 2;
                q.offer(new int[] {point[0]-1, point[1]});
            }
            if (point[0]+1 <n && arr[point[0]+1][point[1]]==1) {
                arr[point[0]+1][point[1]] = 2;
                q.offer(new int[] {point[0]+1, point[1]});
            }
            if (point[1]-1 >=0 && arr[point[0]][point[1]-1]==1) {
                arr[point[0]][point[1]-1] = 2;
                q.offer(new int[] {point[0], point[1]-1});
            }
            if (point[1]+1 <m && arr[point[0]][point[1]+1]==1) {
                arr[point[0]][point[1]+1] = 2;
                q.offer(new int[] {point[0], point[1]+1});
            }
        }
    }
}
