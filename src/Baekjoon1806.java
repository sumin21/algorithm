import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon1806 {
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int n,s;
    public static int min=0;
    public static int[] arr;
    public void Baekjoon1806() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;
        int sum= arr[start];
        while (start<=end && end<n) {
            if (start==end) {
                if (sum >= s) {
                    min = 1;
                    break;
                } else {
                    end++;
                    if (end <n) sum += arr[end];
                }
            } else {
                if (sum > s) {
                    if (min==0 || min>end-start+1) min = end-start+1;
                    start++;
                    sum -= arr[start-1];
                } else if (sum == s) {
                    if (min==0 || min>end-start+1) min = end-start+1;
                    start++;
                    end++;
                    sum -= arr[start-1];
                    if (end <n) sum += arr[end];
                } else {
                    end++;
                    if (end <n) sum += arr[end];
                }
            }
        }

        bw.write(String.valueOf(min));
        bw.close();
    }
}
