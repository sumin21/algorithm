import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Baekjoon1138 {
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int n;
    public static int arr[];
    public void Baekjoon1138() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = n - 1; i >= 0; i--) {
            list.add(arr[i], i+1);
        }

        for (Integer ele : list) {
            bw.write(ele + " ");
        }
        bw.close();
    }
}
