import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon11054 {
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int n;
    public static int[] arr, result;
    public static Integer[] dp, dp2;
    public static int max=0;

    public void Baekjoon11054() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        result = new int[n];
        dp = new Integer[n];
        dp2 = new Integer[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i=0; i<n; i++) {
            result[i] += lis1(i);
            result[n-i-1] += lis2(n-i-1);
        }
        for (int i=0; i<n; i++) {
            if (max < result[i]) max = result[i];
        }
        bw.write(String.valueOf(max-1));
        bw.close();
    }

    public static int lis1(int a) {
        if (dp[a] == null) {
            dp[a] = 1;

            for (int i=a-1; i>=0; i--) {
                if (arr[i] < arr[a]) {
                    dp[a] = Math.max(dp[a], dp[i]+1);
                }
            }
        }

        return dp[a];

    }

    public static int lis2(int a) {
        if (dp2[a] == null) {
            dp2[a] = 1;

            for (int i=a+1; i<n; i++) {
                if (arr[i] < arr[a]) {
                    dp2[a] = Math.max(dp2[a], dp2[i]+1);
                }
            }
        }

        return dp2[a];

    }

}
