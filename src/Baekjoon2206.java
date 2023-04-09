import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
    int x;
    int y;
    boolean isBreak;
    Point (int x, int y, boolean isBreak) {
        this.x = x;
        this.y = y;
        this.isBreak = isBreak;
    }
}
public class Baekjoon2206 {
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int n,m;
    public static int[][][] arr;
    public static int[][] diff = new int[][] {{-1,0},{1,0},{0,-1},{0,1}};

    public void Baekjoon2206() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m][2];
        for (int i=0; i<n; i++) {
            String str = br.readLine();
            for (int j=0; j<m; j++) {
                char c = str.charAt(j);
                if (c == '1') arr[i][j][0] = -1;
            }
        }
        boolean res = bfs();
        if (res) bw.write(String.valueOf(Math.max(arr[n-1][m-1][0], arr[n-1][m-1][1])));
        else bw.write("-1");
        bw.close();
    }

    public static boolean bfs() {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(0,0, false));
        arr[0][0][0] = 1;
        while (!q.isEmpty()) {
            Point now = q.poll();
            if (now.x == n-1 && now.y == m-1) return true;
            for (int[] dif : diff) {
                int newX = now.x+dif[0];
                int newY = now.y+dif[1];

                if (newX>=0 && newX<n && newY>=0 && newY<m) {
                    if (arr[newX][newY][0] == -1 && arr[newX][newY][1] == 0) {
                        if (!now.isBreak) {
                            arr[newX][newY][1] = arr[now.x][now.y][0] + 1;
                            q.offer(new Point(newX, newY, true));
                        }
                    }
                    else if (arr[newX][newY][0] != -1) {
                        if (!now.isBreak && arr[newX][newY][0] == 0) {
                            arr[newX][newY][0] = arr[now.x][now.y][0] + 1;
                            q.offer(new Point(newX, newY, false));
                        }
                        else if (now.isBreak && arr[newX][newY][1] == 0) {
                            arr[newX][newY][1] = arr[now.x][now.y][1] + 1;
                            q.offer(new Point(newX, newY, true));
                        }
                    }
                }
            }
        }

        return false;
    }
}
