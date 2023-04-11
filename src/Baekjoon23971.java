import java.io.*;
import java.util.StringTokenizer;

public class Baekjoon23971 {
    public static int h,w,n,m;
    public static int[][] arr;
    public static int result = 0;
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public void Baekjoon23971() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i=0; i<h; i+=n+1) {
            for (int j=0; j<w; j+=m+1) {
                result+=1;
            }
        }

        bw.write(String.valueOf(result));
        bw.close();
    }
}
