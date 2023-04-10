import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon20040 {
    public static int n,m;
    public static int[] arr;
    public static int result = 0;
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public void Baekjoon20040() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = i;
        }
        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int xp = findP(x);
            int yp = findP(y);
            if (xp == yp) {
                result = i+1;
                break;
            }
            union(x, y);
        }

        bw.write(String.valueOf(result));
        bw.close();
    }

    public static void union(int a, int b) {
        int ap = findP(a);
        int bp = findP(b);
        arr[ap] = Math.min(ap, bp);
        arr[bp] = Math.min(ap, bp);
    }

    public static int findP(int a) {
        if (a == arr[a]) return a;
        else return arr[a] = findP(arr[a]);
    }
}
