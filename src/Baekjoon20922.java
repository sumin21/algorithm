import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon20922 {
    public static int n,k;
    public static int[] arr, num;
    public static int max = 1;
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public void Baekjoon20922() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n];
        num = new int[100001];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;
        num[arr[0]] = 1;

        while (start <= end && end < n) {
//            System.out.println("start = " + start);
//            System.out.println("end = " + end);
            if (end+1<n && num[arr[end+1]]<k) {
                end += 1;
                max = Math.max(max, end-start+1);
                num[arr[end]] += 1;
            } else if (start==end) {
                num[arr[start]] -= 1;
                start += 1;
                end += 1;
                if (end<n) num[arr[end]] += 1;
            }
            else {
                num[arr[start]] -= 1;
                start += 1;
            }

            if (end == n) break;
        }

        bw.write(String.valueOf(max));
        bw.close();
    }
}
