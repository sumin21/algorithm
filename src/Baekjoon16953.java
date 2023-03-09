import java.io.*;
import java.util.StringTokenizer;

public class Baekjoon16953 {
    public static int a,b;
    public static int result = 0;
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public void Baekjoon16953() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        while (true) {
            if ( a>b) {
                result = -1;
                break;
            }
            else if (a == b) {
                result++;
                break;
            }

            if (b % 10 == 1) {
                b--;
                b /= 10;
            } else if (b%2 == 0) {
                b /= 2;
            } else {
                result = -1;
                break;
            }
            result++;
        }
        bw.write(String.valueOf(result));
        bw.close();
    }
}
