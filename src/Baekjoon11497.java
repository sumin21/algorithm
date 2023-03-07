import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon11497 {
    public static int t, n, max;
    public static int[] arr, resultArr;
    public void Baekjoon11497() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        for (int i=0; i<t; i++) {
            n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr = new int[n];
            for (int j=0; j<n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);

            resultArr = new int[n];
            for (int j=0; j<n; j++) {
                if (j%2 == 0) resultArr[j/2] = arr[j];
                else resultArr[n-(j/2+1)] = arr[j];
            }

            max = 0;
            for (int j=1; j<n; j++) {
                int diff = Math.abs(resultArr[j] - resultArr[j-1]);
                if (max < diff) max = diff;
            }
            if (max < resultArr[n-1] - resultArr[0]) max = resultArr[n-1] - resultArr[0];
            System.out.println(max);
        }
        
    }
}
