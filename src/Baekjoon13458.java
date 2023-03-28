import java.io.*;
import java.util.StringTokenizer;

public class Baekjoon13458 {
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int n,b,c;
    public static long result;
    public static int[] arr;

    public void Baekjoon13458() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        result = n;
        for(int i=0; i<n; i++) {
            if (arr[i] < b) arr[i] = 0;
            else arr[i] -= b;
        }

        for(int i=0; i<n; i++) {
            if (arr[i] == 0) continue;
            if (c >= arr[i]) result++;
            else {
                if(arr[i]%c != 0) result += (arr[i]/c + 1);
                else result += (arr[i]/c);
            }
        }
        bw.write(String.valueOf(result));
        bw.close();
    }
}
