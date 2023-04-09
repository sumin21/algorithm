import java.io.*;
import java.util.*;

public class Baekjoon7576 {
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int n,m;
    public static int[][] arr;
    public static int minus = 0;
    public static int total = 0;
    public static Queue<int[]> queue = new LinkedList<>();
    public void Baekjoon7576() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n][m];

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1) {
                    total+=1;
                    queue.offer(new int[] {i,j});
                }
                else if (arr[i][j] == -1) minus+=1;

            }
        }
        if (total == n*m-minus) bw.write("0");
        bfs();
        bw.close();
    }

    public static void bfs() throws IOException{
        int i1 = -1;
        int i2 = -1;
        while(!queue.isEmpty()) {
            int[] spot = queue.poll();
            i1 = spot[0];
            i2 = spot[1];

            if (i1>0 && arr[i1-1][i2] == 0) { //위 ㅇㅇ
                queue.offer(new int[] {i1-1,i2});
                arr[i1-1][i2] = arr[i1][i2] +1;
                total += 1;
            }
            if (i1<n-1 && arr[i1+1][i2] == 0) { //아래 ㅇㅇ
                queue.offer(new int[] {i1+1,i2});
                total += 1;
                arr[i1+1][i2] = arr[i1][i2] +1;

            }
            if (i2>0 && arr[i1][i2-1] == 0) { //왼 ㅇㅇ
                queue.offer(new int[] {i1,i2-1});
                total += 1;
                arr[i1][i2-1] = arr[i1][i2] +1;

            }
            if (i2<m-1 && arr[i1][i2+1] == 0) { //오 ㅇㅇ
                queue.offer(new int[] {i1,i2+1});
                total += 1;
                arr[i1][i2+1] = arr[i1][i2] +1;

            }
        }

        if (total != (n*m-minus)) bw.write("-1");
        else bw.write(String.valueOf(arr[i1][i2]-1));
    }
}