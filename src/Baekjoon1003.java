import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon1003 {
    public static int t,n;
    public static int[][] arr;
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public void Baekjoon1003() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        for (int i=0; i<t; i++) {
            n = Integer.parseInt(br.readLine());
            if (n == 0) {
                bw.write("1 0");
                bw.newLine();
                continue;
            }

            arr = new int[n+1][2];
            arr[0] = new int[] {1,0};
            arr[1] = new int[] {0,1};

            fib(n);
            bw.write(String.valueOf(arr[n][0]) + " " + String.valueOf(arr[n][1]));
            bw.newLine();
        }
        bw.close();
    }

    public static int[] fib(int a) throws IOException{
        if (arr[a][0] != 0 || arr[a][1] != 0){
            // 이미 호출
            return arr[a];
        }
        arr[a][0] = fib(a-1)[0] + fib(a-2)[0];
        arr[a][1] = fib(a-1)[1] + fib(a-2)[1];
        return arr[a];
    }
}
