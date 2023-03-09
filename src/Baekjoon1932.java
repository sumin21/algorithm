import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon1932 {
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int n;
    public static int[][] arr;
    public void Baekjoon1932() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<i+1; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i=n-1; i>0; i--) {
            for (int j=0; j<i; j++) {
                arr[i-1][j] += Math.max(arr[i][j], arr[i][j+1]);
            }
        }

        bw.write(String.valueOf(arr[0][0]));

        bw.close();
    }
}
