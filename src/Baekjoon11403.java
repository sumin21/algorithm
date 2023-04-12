import java.io.*;
import java.util.*;

public class Baekjoon11403 {
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int n;
    public static int[][] arr;


    public void Baekjoon11403() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for (int i=0; i<n;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                for (int k = 0; k < n; k++) {
                    if (arr[j][i]!=0 && arr[i][k]!=0) arr[j][k] = 1;
                }
            }
        }

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                bw.write(String.valueOf(arr[i][j]) + " ");
            }
            bw.newLine();
        }
        bw.close();
    }
}
