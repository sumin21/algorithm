import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon16139 {
    public static int n;
    public static String s;
    public static int[][] arr;
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public void Baekjoon16139() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        arr = new int[26][s.length()+1];

        for (int i=1; i<=s.length(); i++) {
            int idx = Integer.valueOf(s.charAt(i-1))-97;
            for (int j=0; j<26; j++) {
                if (j == idx) arr[idx][i] = arr[idx][i-1] + 1;
                else arr[j][i] = arr[j][i-1];
            }
        }

        n = Integer.parseInt(br.readLine());

        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cIdx = Integer.valueOf(st.nextToken().charAt(0))-97;
            int idx1 = Integer.parseInt(st.nextToken());
            int idx2 = Integer.parseInt(st.nextToken());
            int result = 0;

            bw.write(String.valueOf(arr[cIdx][idx2+1] - arr[cIdx][idx1]));
            bw.newLine();
        }
        bw.close();
    }
}
