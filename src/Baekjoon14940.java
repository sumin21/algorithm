import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon14940 {
    public static int n,m,startX, startY;
    public static int[][] arr;
    public static boolean[][] visit;
    public static int[][] diff = new int[][] {{0,-1},{0,1},{-1,0},{1,0}};
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public void Baekjoon14940() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visit = new boolean[n][m];
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 2) {
                    startX = i;
                    startY = j;
                }
            }
        }
        bfs(startX, startY);
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (!visit[i][j] && arr[i][j]!=0) bw.write("-1");
                else bw.write(String.valueOf(arr[i][j]));
                bw.write(" ");
            }
            bw.newLine();
        }
        bw.close();
    }

    public static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {x,y});
        visit[x][y] = true;
        arr[x][y] = 0;
        while(!q.isEmpty()) {
            int[] now = q.poll();
            for (int[] d : diff) {
                int[] next = new int[] {now[0]+d[0], now[1]+d[1]};
                if (next[0]>=0 && next[0]<n && next[1]>=0 && next[1]<m && !visit[next[0]][next[1]] && arr[next[0]][next[1]] != 0) {
                    visit[next[0]][next[1]] = true;
                    arr[next[0]][next[1]] = arr[now[0]][now[1]]+1;
                    q.offer(next);
                }
            }
        }
    }
}
