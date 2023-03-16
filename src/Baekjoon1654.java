import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon1654 {
    public static int n, m;
    public static int[] arr;
    public static long inputMax = 0;
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public void Baekjoon1654() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if (inputMax < arr[i]) inputMax = arr[i];
        }

        long result = upper(0, inputMax+1);
        bw.write(String.valueOf(result-1));
        bw.close();
    }

    public static long upper(long min, long max) {
        while (min < max) {

            // 범위 내에서 중간 길이를 구한다.
            long mid = (max + min) / 2;

            long count = 0;

            for (int i = 0; i < arr.length; i++) {
                count += (arr[i] / mid);
            }

            if(count < m) {
                max = mid;
            }
            else {
                min = mid + 1;
            }

        }

        return min;
    }
}
