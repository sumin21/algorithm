import java.io.*;
import java.util.StringTokenizer;

public class Baekjoon2512 {
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int n,m;
    public static int inputMax = 0;
    public static int arr[];
    public void Baekjoon2512() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (inputMax < arr[i]) inputMax = arr[i];
        }
        m = Integer.parseInt(br.readLine());
        int result = upper(0, inputMax+1);
        bw.write(String.valueOf(result));
        bw.close();
    }

    public static int upper(int min, int max) {
        while (min < max) {
            int mid = (min+max) /2;
            int money = 0;
            for (int i=0; i<n; i++) {
                if (arr[i] < mid) money += arr[i];
                else money += mid;
            }

            if (m < money) max = mid;
            else min = mid+1;

        }
        return min-1;
    }
}
