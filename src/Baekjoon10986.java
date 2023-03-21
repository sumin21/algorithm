import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon10986 {
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int n,m;
    public static long[] arr,remainders;
    public static long result = 0;
    public void Baekjoon10986() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new long[n + 1];
        remainders = new long[m];
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            arr[i] = (Integer.parseInt(st.nextToken()) + arr[i - 1]) % m;
            if (arr[i] == 0) result++;
            remainders[Long.valueOf(arr[i]).intValue()]++;
        }
        for (int i = 0; i < m; i++) {
            if (remainders[i] > 1) {
                result += (remainders[i] * (remainders[i] - 1)) / 2;
            }
        }
        bw.write(String.valueOf(result));
        bw.close();
    }

}
