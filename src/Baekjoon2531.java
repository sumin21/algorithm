import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon2531 {
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int n,d,k,c;
    public static int[] arr;
    public static int[] bool;
    public static int max = 0;

    public void Baekjoon2531() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new int[n+k-1];
        bool = new int[d+1];
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        for (int i=n; i<n+k-1; i++) {
            arr[i] = arr[i-n];
        }
        int sum = 0;
        boolean isK = false;
        for (int i=0; i<k; i++) {
            if(bool[arr[i]] == 0) {
                sum++;
            }
            bool[arr[i]]++;
            if (arr[i] == c) {
                isK = true;
            };
        }
        if (!isK) sum++;
        max = sum;
        sliding(k);
        bw.write(String.valueOf(max));
        bw.close();
    }

    public static void sliding(int idx) {
        int sum = max;
        while (idx < n+k-1) {
//            System.out.println(Arrays.toString(bool));
//            System.out.println(sum);

            if (arr[idx-k] != c && bool[arr[idx-k]]==1) sum--;
//            System.out.println(sum);

            bool[arr[idx-k]]--;
            if (arr[idx] != c && bool[arr[idx]]==0) sum++;
//            System.out.println(sum);

            bool[arr[idx]]++;


            if (max < sum) max = sum;

            idx++;
        }
    }
}
