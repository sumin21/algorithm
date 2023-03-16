import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon10816 {
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int n,m;
    public static int[] arr;
    public static int result = 0;

    public void Baekjoon10816() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<m; i++) {
            int ele = Integer.parseInt(st.nextToken());
            bw.write(String.valueOf(upperBound(ele) - lowerBound(ele)));
            bw.newLine();
        }

        bw.close();
    }

    private static int lowerBound(int key) {
        int lo = 0;
        int hi = arr.length;

        while (lo < hi) {

            int mid = (lo + hi) / 2;

            if (key <= arr[mid]) {
                hi = mid;
            }

            else {
                lo = mid + 1;
            }

        }

        return lo;
    }

    private static int upperBound(int key) {
        int lo = 0;
        int hi = arr.length;

        while (lo < hi) {

            int mid = (lo + hi) / 2;

            if (key < arr[mid]) {
                hi = mid;
            }
            else {
                lo = mid + 1;
            }

        }

        return lo;
    }
}
