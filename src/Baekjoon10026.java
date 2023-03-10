
import java.io.*;
import java.util.*;

public class Baekjoon10026 {
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int n;
    public static int[][] arr, arr2;
    public static int result, result2 = 0;

    public void Baekjoon10026() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n]; //R=1, G=2, B=3
        arr2 = new int[n][n]; //R=1, G=1, B=3
        for (int i=0; i<n; i++) {
            String st = br.readLine();
            for (int j=0; j<n; j++) {
                char c = st.charAt(j);
                if (c=='R') {
                    arr[i][j] = 1;
                    arr2[i][j] = 1;
                }
                else if (c=='G') {
                    arr[i][j] = 2;
                    arr2[i][j] = 1;
                }
                else  {
                    arr[i][j] = 3;
                    arr2[i][j] = 3;
                }
            }
        }

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                int color1 = arr[i][j];
                if (color1 != 0) {
                    bfs(i, j, color1);
                }
                int color2 = arr2[i][j];
                if (color2 != 0) {
                    bfs2(i, j, color2);
                }
            }
        }
        arr = new int[n][n];

        bw.write(String.valueOf(result) + " " + String.valueOf(result2));
        bw.close();
    }

    public static void bfs(int a, int b, int color) throws IOException{
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {a,b});
        arr[a][b] = 0;

        while(!queue.isEmpty()) {
            int[] pollArr = queue.poll();
            int i1 = pollArr[0];
            int i2 = pollArr[1];

            if (i1>0 && arr[i1-1][i2] == color) { //위 ㅇㅇ
                queue.offer(new int[] {i1-1,i2});
                arr[i1-1][i2] = 0;
            }
            if (i1<n-1 && arr[i1+1][i2] == color) { //아래 ㅇㅇ
                queue.offer(new int[] {i1+1,i2});
                arr[i1+1][i2] = 0;
            }
            if (i2>0 && arr[i1][i2-1] == color) { //왼 ㅇㅇ
                queue.offer(new int[] {i1,i2-1});
                arr[i1][i2-1] = 0;
            }
            if (i2<n-1 && arr[i1][i2+1] == color) { //오 ㅇㅇ
                queue.offer(new int[] {i1,i2+1});
                arr[i1][i2+1] = 0;
            }
        }

        result++;
    }

    public static void bfs2(int a, int b, int color) throws IOException{
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {a,b});
        arr2[a][b] = 0;

        while(!queue.isEmpty()) {
            int[] pollArr = queue.poll();
            int i1 = pollArr[0];
            int i2 = pollArr[1];

            if (i1>0 && arr2[i1-1][i2] == color) { //위 ㅇㅇ
                queue.offer(new int[] {i1-1,i2});
                arr2[i1-1][i2] = 0;
            }
            if (i1<n-1 && arr2[i1+1][i2] == color) { //아래 ㅇㅇ
                queue.offer(new int[] {i1+1,i2});
                arr2[i1+1][i2] = 0;
            }
            if (i2>0 && arr2[i1][i2-1] == color) { //왼 ㅇㅇ
                queue.offer(new int[] {i1,i2-1});
                arr2[i1][i2-1] = 0;
            }
            if (i2<n-1 && arr2[i1][i2+1] == color) { //오 ㅇㅇ
                queue.offer(new int[] {i1,i2+1});
                arr2[i1][i2+1] = 0;
            }
        }

        result2++;
    }
}
