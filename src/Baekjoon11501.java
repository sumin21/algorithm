import java.io.*;
import java.util.*;

public class Baekjoon11501 {
    public static int t, n;
    public static long[] arr;

    public static long result = 0;
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public void Baekjoon11501() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        for (int test=0; test<t; test++) {
            result = 0;
            n = Integer.parseInt(br.readLine());
            arr = new long[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            long sum = 0;
            long max = 0;
            int diffIdx = 0;
            for (int i=0; i<n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());

            }

            for( int i = n-1 ; i >= 0 ; i-- ) {
                if(arr[i] > max) {
                    max = arr[i];
                }else {
                    sum += (max - arr[i]);
                }
            }
            bw.write(String.valueOf(sum));
            bw.newLine();
        }
        bw.close();
    }
}
