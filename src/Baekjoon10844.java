import java.io.*;

public class Baekjoon10844 {
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int n;
    public static long[][] dp;


    public void Baekjoon10844() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new long[n][10];
        for (int i=0; i<n; i++) {
            for (int j=0; j<10; j++) {
                if (i==0 && j==0) dp[i][j] = 0;
                else if (i==0) dp[i][j] = 1;
                else {
                    if(j==0) {
                        dp[i][j] = dp[i-1][1]%1000000000;
                    }

                    else if (j==9) {
                        dp[i][j] = dp[i-1][8]%1000000000;
                    }

                    else {
                        dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1])%1000000000;
                    }
                }
            }
        }
        long sum=0;
        for (int i=0; i<10; i++) {
            sum += dp[n - 1][i]%1000000000;
        }
        bw.write(String.valueOf(sum%1000000000));
        bw.close();
    }
}
