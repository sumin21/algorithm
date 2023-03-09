import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon1149 {
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int n;
    public static int arr[][];
    public void Baekjoon1149() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][3];
        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }

        if (n > 1) {
            for (int i = 1; i < n; i++) {
                arr[i][0] += Math.min(arr[i-1][1], arr[i-1][2]);
                arr[i][1] += Math.min(arr[i-1][0], arr[i-1][2]);
                arr[i][2] += Math.min(arr[i-1][0], arr[i-1][1]);
            }
        }
        int result = Math.min(Math.min(arr[n-1][0], arr[n-1][1]), arr[n-1][2]);
        bw.write(String.valueOf(result));
        bw.close();
    }
}
