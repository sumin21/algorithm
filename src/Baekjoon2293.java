import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon2293 {
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int n,k;
    public static int[] arr, coin;
    public void Baekjoon2293() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[k+1];
        coin = new int[n+1];
        for (int i=1; i<=n; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        arr[0] = 1;
         for (int i = 1; i <= n; i++) {
            for (int j = coin[i]; j <= k; j++) {
                arr[j] += arr[j - coin[i]];
            }
        }

        bw.write(String.valueOf(arr[k]));
        bw.close();
    }
}
