import java.io.*;
import java.util.StringTokenizer;

public class Baekjoon11066 {
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int t,k;
    public static int[] sum, arr;
    public static int[][] dp;
    public static int max=0;

    public void Baekjoon11066() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        for (int i=0; i<t; i++) {
            k = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr = new int[k+1];
            sum = new int[k+1];
            dp = new int[k+1][k+1];

            for (int j=0; j<k; j++) {
                arr[j+1] = Integer.parseInt(st.nextToken());
                sum[j+1] = sum[j] + arr[j+1];
            }
            for (int j=0; j<k; j++) {
                dp[j][j+1] = arr[j] + arr[j+1];
            }
            for (int n=1; n<=k; n++) {
                for (int from=1; from+n<=k; from++) {
                    int to = from+n;
                    dp[from][to] = Integer.MAX_VALUE;
                    for (int mid=from; mid<to; mid++) {
                        dp[from][to] = Math.min(dp[from][to], dp[from][mid]+dp[mid+1][to] + sum[to] - sum[from-1]);
                    }
                }
            }

            bw.write(String.valueOf(dp[1][k]));
            bw.newLine();
        }
        bw.close();
    }
}
