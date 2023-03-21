import java.io.*;
import java.util.StringTokenizer;

public class Baekjoon1717 {
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int n,m;
    public static int[] arr;
    public void Baekjoon1717() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n+1];
        for (int i = 0; i <= n; i++) {
            arr[i] = i;
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (num == 0) union(a,b);
            else {
                bw.write(findParent(a)==findParent(b) ? "YES" : "NO");
                bw.newLine();
            }
        }
        bw.close();
    }

    public static int findParent(int a) {
        if (a == arr[a]) return a;
        return findParent(arr[a]);
    }

    public static void union(int a, int b) {
        int ap = findParent(a);
        int bp = findParent(b);
        arr[bp] = ap;
    }
}
