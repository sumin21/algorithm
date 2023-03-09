import java.io.*;
import java.util.StringTokenizer;

public class Baekjoon1463 {
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int n;
    public static int result = 0;
    public static int[] arr;

    public void Baekjoon1463() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n+1];

        if (n>1) arr[2] = 1;
        if (n>2) arr[3] = 1;

        if (n > 3) {
            for (int i = 4; i <= n; i++) {
                int a = arr[i-1];
                if (i%2 == 0) a = Math.min(a, arr[i/2]);
                if (i%3 == 0) a = Math.min(a, arr[i/3]);

                arr[i] = a+1;
            }
        }

        bw.write(String.valueOf(arr[n]));
        bw.close();
    }
}
