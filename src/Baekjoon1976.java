import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon1976 {
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int n,m;
    public static int[] arr;
    public static boolean result=true;
    public void Baekjoon1976() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = i;
        }
        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++) {
                int in = Integer.parseInt(st.nextToken());
                if (in>0) union(i, j);;
            }
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int parent = 0;
        for (int i=0; i<m; i++) {
            int in = Integer.parseInt(st.nextToken());
            if (i==0) parent = findParent(in-1);
            else if (findParent(in-1) != parent) {
                bw.write("NO");
                result = false;
                break;
            }
        }

        if (result) bw.write("YES");
        bw.close();
    }

    public static int findParent(int a){
        if (a == arr[a]) return a;
        return findParent(arr[a]);
    }

    public static void union(int a, int b){
        int x = findParent(a);
        int y = findParent(b);

        if (x != y) {
            if (x < y) {
                arr[y] = x;
            } else {
                arr[x] = y;
            }
        }
    }
}
