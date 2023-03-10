import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon1520 {
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int m,n;
    public static int result = 0;
    public static boolean[][] visit;
    public static int[][] arr, dp;
    public static List<Character> alph = new ArrayList<>();
    public void Baekjoon1520() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        visit = new boolean[m][n];
        arr = new int[m][n];
        dp = new int[m][n];

        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }
        result = dfs(0,0);
        bw.write(String.valueOf(result));
        bw.close();
    }

    public static int dfs(int a, int b) throws IOException{
        visit[a][b] = true;
        if (a == m-1 && b == n-1) {
            return 1;
        }

        if (dp[a][b] != -1) {
            return dp[a][b];
        }

        dp[a][b] = 0;

        if (a>0 && !visit[a-1][b] && arr[a][b] > arr[a-1][b]) { //위
            dp[a][b] += dfs(a-1, b);
            visit[a-1][b] = false;
        }
        if (a<m-1 && !visit[a+1][b] && arr[a][b] > arr[a+1][b]) {//아
            dp[a][b] += dfs(a+1, b);
            visit[a+1][b] = false;
        }
        if (b>0 && !visit[a][b-1] && arr[a][b] > arr[a][b-1]) {//왼
            dp[a][b] += dfs(a, b-1);
            visit[a][b-1] = false;
        }
        if (b<n-1 && !visit[a][b+1] && arr[a][b] > arr[a][b+1]) {//오
            dp[a][b] += dfs(a, b+1);
            visit[a][b+1] = false;
        }

        return dp[a][b];
    }

}
