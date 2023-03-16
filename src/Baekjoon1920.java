import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon1920 {
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int n,m;
    public static int[] arr, findArr;
    public void Baekjoon1920() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        m = Integer.parseInt(br.readLine());
        findArr = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<m; i++) {
            findArr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        for (int i=0; i<m; i++) {
            binarySearch(findArr[i], 0, n-1);
            bw.newLine();
        }

        bw.close();
    }

    public static void binarySearch(int key, int startIdx, int endIdx) throws IOException{
        if (startIdx <= endIdx) {
            int mid = (startIdx + endIdx) / 2;
            if (key == arr[mid]) bw.write("1");
            else if (key < arr[mid]) binarySearch(key, startIdx, mid-1);
            else binarySearch(key, mid+1, endIdx);
        }

        else bw.write("0");
    }
}
