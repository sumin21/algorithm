import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon6603 {
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int k;
    public static int[] arr, result;
    public static boolean[] visit;

    public void Baekjoon6603() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            if (k == 0) {
                break;
            }
            arr = new int[k];
            result = new int[6];
            visit = new boolean[k];
            for (int i = 0; i < k; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            backT(0,0);
            bw.newLine();
        }
        bw.close();
    }

    public static void backT(int start, int idx) throws IOException{
        if (idx == 6) {
            for (int r : result) {
                bw.write(String.valueOf(r)+" ");
            }
            bw.newLine();
            return;
        }

        for (int i=start; i<k; i++) {
            if (!visit[i]) {
                result[idx] = arr[i];
                visit[i] = true;
                backT(i+1, idx+1);
                visit[i] = false;
            }
        }
    }
}
