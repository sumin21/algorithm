import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon11660 {
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int n,m;
    public static int[][] arr;

    public void Baekjoon11660() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n+1][n+1];
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++) {
                arr[i+1][j+1] = Integer.parseInt(st.nextToken()) + arr[i][j+1] + arr[i+1][j] - arr[i][j];
            }
        }

        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            bw.write(String.valueOf(ps(x1, y1, x2, y2)));
            bw.newLine();
        }
        bw.close();
    }

    public static int ps(int x1, int y1, int x2, int y2) {
        return arr[x2][y2] - arr[x1-1][y2] - arr[x2][y1-1] + arr[x1-1][y1-1];
    }
}
