import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon25682 {
    public static int n,m,k;
    public static int[][] arr0, arr1;
    public static int result = 0;
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public void Baekjoon25682() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr0 = new int[n+1][m+1];
        arr1 = new int[n+1][m+1];
        char zero;

        for (int i=0; i<n; i++) {
            String str = br.readLine();
            zero = (i%2==0) ? 'B' : 'W';

            for (int j=0; j<m; j++) {
                char c = str.charAt(j);
                if (c==zero) {
                    arr0[i+1][j+1] = arr0[i][j+1] + arr0[i+1][j] - arr0[i][j];
                    arr1[i+1][j+1] = arr1[i][j+1] + arr1[i+1][j] - arr1[i][j] + 1;
                }
                else {
                    arr0[i+1][j+1] = arr0[i][j+1] + arr0[i+1][j] - arr0[i][j] + 1;
                    arr1[i+1][j+1] = arr1[i][j+1] + arr1[i+1][j] - arr1[i][j];
                }

                zero = (zero=='B') ? 'W' : 'B';
            }
        }

        int min0 = 4000001;
        int min1 = 4000001;

        for (int i=k; i<=n; i++) {
            for (int j=k; j<=m; j++) {
                min0 = Math.min(min0, arr0[i][j]-arr0[i-k][j]-arr0[i][j-k]+arr0[i-k][j-k]);
                min1 = Math.min(min1, arr1[i][j]-arr1[i-k][j]-arr1[i][j-k]+arr1[i-k][j-k]);
            }
        }
        bw.write(String.valueOf(Math.min(min0, min1)));
        bw.close();
    }
}
