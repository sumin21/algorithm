import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon2230 {
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int n,m;
    public static int[] arr;
    public static int min=-1;
    public void Baekjoon2230() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        bw.write(String.valueOf(twoPointer(0,0)));
        bw.close();
    }

    public static int twoPointer(int start, int end) {
        while (start<=end && end < n) {
            int diff =Math.abs(arr[end]-arr[start]);
            if (diff == m) return diff;
            else if (diff > m) {
                start++;
                if (min == -1 || min >= diff) min = diff;
            }
            else end++;
        }
        return min;
    }
}
