import java.io.*;
import java.util.StringTokenizer;

public class Baekjoon11049 {
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int n;
    public static int[][] arr;
    public static int[][] dp;
    public static int result=0;
    public static int max=0;

    public void Baekjoon11049() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n+1][2];
        dp = new int[n+1][n+1];

        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i+1][0] = Integer.parseInt(st.nextToken());
            arr[i+1][1] = Integer.parseInt(st.nextToken());
        }

        if (n==1) {
            bw.write("0");
        }
        else {
            for (int i = 0; i < n; i++) {
                dp[i][i + 1] = arr[i][0] * arr[i][1] * arr[i + 1][1];
            }


            for (int k = 1; k <= n; k++) {
                for (int from = 1; from + k <= n; from++) {
                    int to = from + k;
                    dp[from][to] = Integer.MAX_VALUE;
                    for (int mid = from; mid < to; mid++) {
                        dp[from][to] = Math.min(dp[from][to], dp[from][mid] + dp[mid+1][to] + arr[from][0]*arr[mid][1]*arr[to][1]);
                    }
                }
            }

            bw.write(String.valueOf(dp[1][n]));
        }
        bw.close();
    }
}
