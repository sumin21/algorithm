import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Baekjoon1946 {
    public static int testN, n;
    public static int[][] arr;
    public static int[] result;

    public void Baekjoon1946() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        testN = Integer.parseInt(br.readLine());
        result = new int[testN];

        for (int i=0; i<testN; i++) {
            n = Integer.parseInt(br.readLine());
            arr= new int[n][2];
            int max = n+1;

            for (int j=0; j<n; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                arr[j][0] = Integer.parseInt(st.nextToken());
                arr[j][1] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr, Comparator.comparingInt(o1 -> o1[0]));

            for (int k=0; k<n; k++) {
                int level = arr[k][1];
                if (max > level) {
                    max = level;
                    result[i]++;
                }
            }
        }

        for (int res: result) {
            System.out.println(res);
        }

    }
}
