import java.io.*;
import java.util.*;

public class Baekjoon2667 {
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int n;
    public static int[][] arr;
    public static List<Integer> result = new ArrayList<>();

    public void Baekjoon2667() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for (int i=0; i<n; i++) {
            String st = br.readLine();
            for (int j=0; j<n; j++) {
                arr[i][j] = Integer.parseInt(String.valueOf(st.charAt(j)));
            }
        }

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (arr[i][j] == 1) {
                    bfs(i, j);
                }
            }
        }
        Collections.sort(result);
        bw.write(String.valueOf(result.size()));
        bw.newLine();
        for (int res: result) {
            bw.write(String.valueOf(res));
            bw.newLine();
        }
        bw.close();
    }

    public static void bfs(int a, int b) throws IOException{
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {a,b});
        int sum = 1;
        arr[a][b] = 2;

        while(!queue.isEmpty()) {
            int[] pollArr = queue.poll();
            int i1 = pollArr[0];
            int i2 = pollArr[1];

            if (i1>0 && arr[i1-1][i2] == 1) { //위 ㅇㅇ
                queue.offer(new int[] {i1-1,i2});
                arr[i1-1][i2] = 2;
                sum++;
            }
            if (i1<n-1 && arr[i1+1][i2] == 1) { //아래 ㅇㅇ
                queue.offer(new int[] {i1+1,i2});
                arr[i1+1][i2] = 2;
                sum++;
            }
            if (i2>0 && arr[i1][i2-1] == 1) { //왼 ㅇㅇ
                queue.offer(new int[] {i1,i2-1});
                arr[i1][i2-1] = 2;
                sum++;
            }
            if (i2<n-1 && arr[i1][i2+1] == 1) { //오 ㅇㅇ
                queue.offer(new int[] {i1,i2+1});
                arr[i1][i2+1] = 2;
                sum++;
            }
//            return;
        }
        result.add(sum);
    }
}
