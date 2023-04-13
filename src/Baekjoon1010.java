import java.io.*;
import java.util.StringTokenizer;

public class Baekjoon1010 {
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int t, c, num;
    public static boolean[] visit;
    public static int result = 0;
    public void Baekjoon1010() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        for (int i=0; i<t; i++) {
            result = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            num = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            visit = new boolean[num];
        }
    }

    public static void combi(int idx, int n) {

    }
}
