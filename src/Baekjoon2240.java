import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon2240 {
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int t,w,end;
    public static int max = 0;
    public static int ans = 0;
    public static int[][] dp;
    public void Baekjoon2240() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        t = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        dp = new int[t+1][w+1];

        for(int i=1; i<=t; i++) {
            int tree = Integer.parseInt(br.readLine());

            for(int j=0; j<=w; j++) {

                //안움직
                if(j == 0) {
                    if(tree == 1)
                        dp[i][j] = dp[i-1][j] + 1;
                    else
                        dp[i][j] = dp[i-1][j];

                    continue;
                }

                //짝수 -> 1
                if(j%2 == 0) {
                    if(tree == 1)
                        dp[i][j] = max(dp[i-1][j-1], dp[i-1][j] + 1);
                    else
                        dp[i][j] = max(dp[i-1][j-1] + 1, dp[i-1][j]);
                }

                // 홀수 -> 1
                else {
                    if(tree == 1)
                        dp[i][j] = max(dp[i-1][j-1] + 1, dp[i-1][j]);
                    else
                        dp[i][j] = max(dp[i-1][j-1], dp[i-1][j] + 1);
                }
            }
        }


        for(int i=0; i<=w; i++)
            ans = max(ans, dp[t][i]);

        bw.write(String.valueOf(ans));
        bw.close();

    }

    static int max(int a, int b) {
        return (a > b) ? a : b;
    }
}