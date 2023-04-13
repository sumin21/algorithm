import java.io.*;
import java.util.StringTokenizer;

public class Baekjoon19637 {
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int n,m;
    public static String[][] arr;
    public static int ans = 0;
    public void Baekjoon19637() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new String[n][2];
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = st.nextToken();
            arr[i][1] = st.nextToken();
        }
        for (int i=0; i<m; i++) {
            int now = Integer.parseInt(br.readLine());
            bw.write(arr[binarySearch(now)][0]);
            bw.newLine();
        }
        bw.close();
    }
    
    public static int binarySearch(int now) {
        int low = 0;
        int high = n-1;
        while (low < high) {
            int mid = (low+high) /2;
            if (now > Integer.parseInt(arr[mid][1])) low = mid+1;
            else high = mid;
        }
        return low;
    }
}
