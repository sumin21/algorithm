import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon2559 {
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int n,c;
    public static int[] arr;
    public static int max = 0;
    public static List<Integer> result = new ArrayList<>();

    public void Baekjoon2559() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (i<c) max += arr[i];
        }
        sliding(c);
        bw.write(String.valueOf(max));
        bw.close();
    }

    public static void sliding(int a) {
        while (a < n) {
            if ((arr[a] - arr[a-c]) > 0) {
                int s = sumFunc(a-c+1, a);
                if (max < s) max = s;
            }
            a++;
        }
    }

    public static int sumFunc(int a, int b) {
        int sum = 0;
        for (int i=a; i<=b; i++) {
            sum += arr[i];
        }
        return sum;
    }
}
