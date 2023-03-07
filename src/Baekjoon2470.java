import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon2470 {
    public static int n, start, end;
    public static int[] arr;
    public static int min = -1;
    public static int[] resultArr;
    public void Baekjoon2470() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n];
        resultArr = new int[2];
        start = 0;
        end = n-1;
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        while(start < end) {
            int sum = arr[start] + arr[end];
            if(min == -1 || min > Math.abs(sum)) {
                min = Math.abs(sum);
                resultArr[0] = arr[start];
                resultArr[1] = arr[end];
            }
            if(sum > 0) end--;
            else start++;


            if(sum == 0) break;
        }

        System.out.println(Integer.toString(resultArr[0]) + " " + Integer.toString(resultArr[1]));
    }
}
