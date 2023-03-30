import java.io.*;
import java.util.StringTokenizer;

public class Baekjoon1629 {
    public static int a,b,c;
    public static int[] arr;
    public static long inputMax = 0;
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public void Baekjoon1629() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        bw.write(String.valueOf(a%b));
        bw.close();
    }
}
