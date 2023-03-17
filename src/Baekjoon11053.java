import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon11053 {
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int n;
    public static int[] arr;
    public static Integer[] dp;
    public static int result=0;
    public static int max=0;

    public void Baekjoon11053() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        dp = new Integer[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i=0; i<n; i++) {
            int res = lis(i);
            if (max < res) max = res;
        }
        bw.write(String.valueOf(max));
        bw.close();
    }

    public static int lis(int a) {
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

}
