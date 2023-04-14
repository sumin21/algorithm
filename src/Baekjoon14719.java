import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Baekjoon14719 {
    public static int h,w,leftH,rightH;
    public static int sum=0;
    public static int[] arr;
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public void Baekjoon14719() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        arr = new int[w];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<w; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i=0; i<w; i++) {
            leftH=0;
            rightH=0;
            for (int j=0; j<i;j++) {
                leftH = Math.max(leftH, arr[j]);
            }
            for (int k=w-1; k>i;k--) {
                rightH = Math.max(rightH, arr[k]);
            }
            if (leftH>arr[i] && rightH>arr[i]) sum += Math.min(leftH,rightH)-arr[i];
        }
        bw.write(String.valueOf(sum));
        bw.close();
    }
}
