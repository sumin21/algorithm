import java.io.*;
import java.util.StringTokenizer;

public class Baekjoon1912 {
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int n;
    public static long[] arr;
    public static long max = Long.MIN_VALUE;
    public static long min = 0;


    public void Baekjoon1912() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new long[n+1];
        for (int i=0; i<n; i++) {
            int inp = Integer.parseInt(st.nextToken());
            arr[i+1] = arr[i] + inp;
            long m = arr[i+1]-min;
            min = Math.min(arr[i+1], min);
            max = Math.max(m, max);

        }
        bw.write(String.valueOf(max));
        bw.close();
    }
}
