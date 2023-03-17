import java.io.*;
import java.util.StringTokenizer;

public class Baekjoon11722 {
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int n;
    public static int[] arr;
    public static Integer[] dp;
    public static int max=0;

    public void Baekjoon11722() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        dp = new Integer[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i=n-1; i>=0; i--) {
            int res = lis(i);
            if (max < res) max = res;
        }
        bw.write(String.valueOf(max));
        bw.close();
    }

    public static int lis(int a) {
        if (dp[a] == null) {
            dp[a] = 1;

            for (int i=a+1; i<n; i++) {
                if (arr[i] < arr[a]) {
                    dp[a] = Math.max(dp[a], dp[i]+1);
                }
            }
        }

        return dp[a];

    }

}

