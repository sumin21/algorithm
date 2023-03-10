import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon2178 {
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int n,m;
    public static int[][] arr;
    public static boolean[][] visit;
    public void Baekjoon2178() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visit = new boolean[n][m];

        for (int i=0; i<n; i++) {
            String s = br.readLine();
            for (int j=0; j<m; j++) {
                arr[i][j] = Integer.parseInt(String .valueOf(s.charAt(j)));
            }
        }

        bfs(0,0);
        bw.write(String.valueOf(arr[n-1][m-1]));
        bw.close();
    }

    public static void bfs(int a, int b) throws IOException{
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {a,b});
        visit[a][b] = true;

        while(!queue.isEmpty()) {
            int[] spot = queue.poll();
            int i1 = spot[0];
            int i2 = spot[1];
            if (i1>0 && arr[i1-1][i2] == 1 && !visit[i1-1][i2]) { //위 ㅇㅇ
                queue.offer(new int[] {i1-1,i2});
                visit[i1-1][i2] = true;
                arr[i1-1][i2] = arr[i1][i2] +1;
            }
            if (i1<n-1 && arr[i1+1][i2] == 1 && !visit[i1+1][i2]) { //아래 ㅇㅇ
                queue.offer(new int[] {i1+1,i2});
                visit[i1+1][i2] = true;
                arr[i1+1][i2] = arr[i1][i2] +1;

            }
            if (i2>0 && arr[i1][i2-1] == 1 && !visit[i1][i2-1]) { //왼 ㅇㅇ
                queue.offer(new int[] {i1,i2-1});
                visit[i1][i2-1] = true;
                arr[i1][i2-1] = arr[i1][i2] +1;

            }
            if (i2<m-1 && arr[i1][i2+1] == 1 && !visit[i1][i2+1]) { //오 ㅇㅇ
                queue.offer(new int[] {i1,i2+1});
                visit[i1][i2+1] = true;
                arr[i1][i2+1] = arr[i1][i2] +1;

            }
        }
    }
}
