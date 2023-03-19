import java.io.*;
import java.util.StringTokenizer;

public class Baekjoon11659 {
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int n,t;
    public static int[] arr;

    public void Baekjoon11659() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        arr = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i=1; i<=n; i++) {
            arr[i] = Integer.parseInt(st.nextToken()) + arr[i-1];
        }

        for (int i=0; i<t; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            bw.write(String.valueOf(ps(start, end)));
            bw.newLine();
        }
        bw.close();
    }

    public static int ps(int start, int end) {
        return arr[end] - arr[start-1];
    }

}
