import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon2003 {
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int n,s;
    public static int result = 0;
    public static int[] arr;
    public void Baekjoon2003() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        twoPointer(0,0);
        bw.write(String.valueOf(result));
        bw.close();
    }

    public static void twoPointer(int start, int end) {
        while (start <= end && end<n) {
            int sum = 0;
            for (int i=start; i<=end; i++) {
                sum += arr[i];
            }
            if (sum < s) end++;
            else if (start==end && sum > s) {
                start++;
                end++;
            }
            else if (start!=end && sum > s) start++;
            else {
                result++;
                start++;
                end++;
            }
        }
    }
}
