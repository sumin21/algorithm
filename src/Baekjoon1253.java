import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon1253 {
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int n;
    public static int[] arr;
    public static int result = 0;
    public void Baekjoon1253() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        for (int i=0; i<n; i++) {
            threePointer(0,n-1,i);
        }
//        if (arr[0]+arr[2] == arr[1]) result++;
//        if (arr[1]+arr[2] == arr[0]) result++;
        bw.write(String.valueOf(result));
        bw.close();
    }

    public static void threePointer(int start, int end, int next) {
        while (start<end && next<n) {
            if (start == next) {
                start++;
                continue;
            }
            if (end == next) {
                end--;
                continue;
            }
            if (start==end) {
                break;
            }

            if (arr[start] + arr[end] < arr[next]) start++;
            else if (arr[start]+arr[end] > arr[next]) end--;
            else {
                result++;
                break;
            }
        }
    }
}
