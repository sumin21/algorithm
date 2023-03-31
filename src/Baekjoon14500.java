import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon14500 {
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int n,m;
    public static int[][] arr;
    public static boolean[][] boolArr;
    public static int max=0;

    public void Baekjoon14500() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        boolArr = new boolean[n][m];

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                boolArr[i][j] = true;
                solution(new int[] {-1,-1}, new int[] {i,j}, arr[i][j], 1);
                boolArr[i][j] = false;
            }
        }

        bw.write(String.valueOf(max));
        bw.close();
    }
    public static void solution(int[] before, int[] last, int sum, int count) {
//        System.out.println(sum);
//        for (int i=0; i<n; i++) {
//            System.out.println(Arrays.toString(boolArr[i]));
//        }
//        System.out.println("/////");
        if (count == 4) {
            max = Math.max(max, sum);
            return;
        }

        // 아래
        if (last[0] + 1 < n && !boolArr[last[0]+1][last[1]]) {
            boolArr[last[0] + 1][last[1]] = true;
            solution(last, new int[]{last[0] + 1, last[1]}, sum + arr[last[0] + 1][last[1]], count + 1);
            boolArr[last[0] + 1][last[1]] = false;
        }
        if (last[0] - 1 >= 0 && !boolArr[last[0]-1][last[1]]) {
            boolArr[last[0] - 1][last[1]] = true;
            solution(last, new int[]{last[0] - 1, last[1]}, sum + arr[last[0] - 1][last[1]], count + 1);
            boolArr[last[0] - 1][last[1]] = false;
        }
        // 오
        if (last[1] + 1 < m && !boolArr[last[0]][last[1]+1]) {
            boolArr[last[0]][last[1]+1] = true;
            solution(last, new int[]{last[0], last[1] + 1}, sum + arr[last[0]][last[1] + 1], count + 1);
            boolArr[last[0]][last[1]+1] = false;
        }
        if (last[1] - 1 >= 0 && !boolArr[last[0]][last[1]-1]) {
            boolArr[last[0]][last[1]-1] = true;
            solution(last, new int[]{last[0], last[1] - 1}, sum + arr[last[0]][last[1] - 1], count + 1);
            boolArr[last[0]][last[1]-1] = false;
        }

        if (before[0] != -1 && before[1] != -1) {
            if (before[0] + 1 < n && !boolArr[before[0] + 1][before[1]]) {
                boolArr[before[0] + 1][before[1]] = true;
                solution(last, new int[]{before[0] + 1, before[1]}, sum + arr[before[0] + 1][before[1]], count + 1);
                boolArr[before[0] + 1][before[1]] = false;
            }
            if (before[0] - 1 >= 0 && !boolArr[before[0] - 1][before[1]]) {
                boolArr[before[0] - 1][before[1]] = true;
                solution(last, new int[]{before[0] - 1, before[1]}, sum + arr[before[0] - 1][before[1]], count + 1);
                boolArr[before[0] - 1][before[1]] = false;
            }
            // 오
            if (before[1] + 1 < m && !boolArr[before[0]][before[1] + 1]) {
                boolArr[before[0]][before[1] + 1] = true;
                solution(last, new int[]{before[0], before[1] + 1}, sum + arr[before[0]][before[1] + 1], count + 1);
                boolArr[before[0]][before[1] + 1] = false;
            }
            if (before[1] - 1 >= 0 && !boolArr[before[0]][before[1] - 1]) {
                boolArr[before[0]][before[1] - 1] = true;
                solution(last, new int[]{before[0], before[1] - 1}, sum + arr[before[0]][before[1] - 1], count + 1);
                boolArr[before[0]][before[1] - 1] = false;
            }
        }

        return;
    }
}
