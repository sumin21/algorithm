import java.io.*;
import java.util.*;

public class Baekjoon2110 {
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int n,c;
    public static int inputMax = 0;
    public static int[] arr;
    public void Baekjoon2110() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int result = upper(0, arr[n-1]-arr[0]+1); // 최대값 설정 중요
        bw.write(String.valueOf(result-1));
        bw.close();
    }

    public static int upper(int min, int max) {
        Stack<Integer> stack = new Stack<>();

        while (min < max) {
            int mid = (min+max) / 2;
            stack.clear();
            stack.push(arr[0]);
            for (int i=1; i<n; i++) {
                if ((arr[i]-stack.peek()) >= mid) stack.push(arr[i]);
            }
            int count = stack.size();
            if (count < c) max = mid;
            else min = mid+1;
        }

        return min;
    }
}
