import java.io.*;
import java.util.StringTokenizer;

public class Baekjoon2805 {
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int n;
    public static long m;
    public static int maxH = 0;
    public static int[] arr;

    public void Baekjoon2805() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Long.parseLong(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            maxH = Math.max(maxH, arr[i]);
        }
        bw.write(String.valueOf(upper(0,maxH)-1));
        bw.close();
    }

    public static int upper(int low, int high) {
        while(low < high) {
            int mid = (low + high) / 2;
            if (m > getHighSum(mid)) high = mid;
            else low = mid + 1;
        }
        return low;
    }

    public static long getHighSum(int h) {
        long sum = 0;
        for (int i=0; i<n; i++) {
            if (arr[i] > h) sum += (arr[i] - h);
        }
        return sum;
    }
}
