import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon9465 {
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int t,n;
    public static int[][] arr;
    public static boolean[] possibleArr;


    public void Baekjoon9465() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        for (int i=0; i<t; i++) {
            n = Integer.parseInt(br.readLine());
            arr = new int[2][n];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++) {
                arr[0][j] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());

            for (int j=0; j<n; j++) {
                arr[1][j] = Integer.parseInt(st.nextToken());
            }
            int result = dp();
            bw.write(String.valueOf(result));
            bw.newLine();
        }
        bw.close();

    }

    public static int dp(){
        arr[0][1] += arr[1][0];
        arr[1][1] += arr[0][0];
        for (int i=2; i<n; i++) {
            arr[0][i] += Math.max(arr[1][i-1], arr[1][i-2]);
            arr[1][i] += Math.max(arr[0][i-1], arr[0][i-2]);
        }

        return Math.max(arr[0][n-1], arr[1][n-1]);
    }
}
