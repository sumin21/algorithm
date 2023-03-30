import java.io.*;

public class Baekjoon9251 {
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static String s1, s2;
    public static int[][] arr;


    public void Baekjoon9251() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s1 = br.readLine();
        s2 = br.readLine();
        int s1Len = s1.length();
        int s2Len = s2.length();
        arr = new int[s1Len+1][s2Len+1];

        for (int i=1; i<=s1Len; i++) {
            for (int j=1; j<=s2Len; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) arr[i][j] = arr[i-1][j-1]+1;
                else arr[i][j] = Math.max(arr[i-1][j], arr[i][j-1]);
            }
        }

        bw.write(String.valueOf(arr[s1Len][s2Len]));
        bw.close();
    }
}
