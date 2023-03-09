import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon2839 {
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int n;
    public static int result = 0;
    public static int[][] arr;

    public void Baekjoon2839() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[2][n+1];

        for (int i=1; i<=5; i++) {
            arr[0][i] = 0;
            arr[1][i] = 0;
            if (i == 3) arr[0][i] = 1;
            if (i == 5) arr[1][i] = 1;
            if (i == n) break;
        }
        if (n > 5) {
            for (int i = 6; i <= n; i++) {
                int sum3 = 0;
                int sum5 = 0;
                if (arr[0][i - 3] != 0 || arr[1][i - 3] != 0) {
                    sum3 = arr[0][i - 3] + 1 + arr[1][i - 3];
                }
                if (arr[0][i - 5] != 0 || arr[1][i - 5] != 0) {
                    sum5 = arr[0][i - 5] + arr[1][i - 5] + 1;
                }
                if (sum3 == 0 && sum5 == 0) {
                    continue;
                }
                else if (sum3 == 0) {
                    arr[0][i] = arr[0][i - 5];
                    arr[1][i] = arr[1][i - 5] + 1;
                }
                else if (sum5 == 0) {
                    arr[0][i] = arr[0][i - 3] + 1;
                    arr[1][i] = arr[1][i - 3];
                }
                else if (sum3 < sum5) {
                    arr[0][i] = arr[0][i - 3] + 1;
                    arr[1][i] = arr[1][i - 3];
                } else {
                    arr[0][i] = arr[0][i - 5];
                    arr[1][i] = arr[1][i - 5] + 1;
                }
            }
        }

        int result = (arr[0][n] + arr[1][n]) == 0 ? -1 : arr[0][n] + arr[1][n];
        bw.write(String.valueOf(result));
        bw.close();
    }
}
