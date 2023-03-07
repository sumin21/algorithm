import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon3273 {
    public static int n, sum, start, end;
    public static int[] arr;
    public static int result = 0;

    public void Baekjoon3273() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n];

        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        sum = Integer.parseInt(br.readLine());
        start = 0;
        end = n-1;

        Arrays.sort(arr);

        while(start < end) {
            int diff = sum - arr[start];
            if(arr[end] == diff) {
                result++;
                start++;
                end--;
            }
            else if (arr[end] < diff) start++;
            else end--;
        }
        System.out.println(result);

    }
}
