import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon2212 {
    public static int n,k;
    public static int[] arr, diffArr;
    public static int sum = 0;
    public void Baekjoon2212() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n];
        diffArr = new int[n-1];

        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        for (int i=1; i<n; i++) {
            diffArr[i-1] = arr[i] - arr[i-1];
        }

        Arrays.sort(diffArr);

        for (int i=0; i<n-k; i++) {
            sum += diffArr[i];
        }
        System.out.println(sum);

    }
}
