import java.io.*;
import java.util.StringTokenizer;

public class Baekjoon9184 {
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int a,b,c;
    public static int[][][] dp = new int[101][101][101];


    public void Baekjoon9184() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            if (a==-1 && b==-1 && c==-1) break;
            int res = solution(a,b,c);
            bw.write("w("+String.valueOf(a)+", "+String.valueOf(b)+", "+String.valueOf(c)+") = "+String.valueOf(res));
            bw.newLine();
        }
        bw.close();
    }

    public static int solution(int a, int b, int c) {
        if (dp[a+50][b+50][c+50] != 0) return dp[a+50][b+50][c+50];
        else if (a <= 0 || b <= 0 || c <= 0) return 1;
        else if ( a > 20 || b > 20 || c > 20) return dp[a+50][b+50][c+50] = solution(20,20,20);
        else if (a < b && b < c) return dp[a+50][b+50][c+50] =solution(a, b, c-1) + solution(a, b-1, c-1) - solution(a, b-1, c);
        else return dp[a+50][b+50][c+50] = solution(a-1, b, c) + solution(a-1, b-1, c) + solution(a-1, b, c-1) - solution(a-1, b-1, c-1);

    }
}
