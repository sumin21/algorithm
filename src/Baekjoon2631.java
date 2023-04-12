import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Baekjoon2631 {
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int n;
    public static int max = 0;
    public static int[] arr,dp;
    public static List<Integer> result = new ArrayList<>();

    public void Baekjoon2631() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        dp = new int[n+1];
        for (int i=1; i<=n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        for (int i=1; i<=n; i++) {
            for (int j=0; j<i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                    max = Math.max(max, dp[i]);
                }
            }
        }
        bw.write(Arrays.toString(dp));
        bw.write(String.valueOf(n-max));
        bw.close();
    }
}
