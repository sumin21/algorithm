import java.io.*;
import java.util.StringTokenizer;

public class Baekjoon1182 {
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int n,s;
    public static int[] arr;
    public static int result=0;
    public void Baekjoon1182() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < n; i++) {
            backT(i,0);
        }
        bw.write(String.valueOf(result));
        bw.close();
    }

    public static void backT(int end, int sum) { //end 선택됨
        int nowSum = arr[end]+sum;
        if (end == n) return;
        if (nowSum == s) {
            result++;
        }

        for (int i=end+1; i<n; i++) {
            backT(i, nowSum);
        }
    }
}
