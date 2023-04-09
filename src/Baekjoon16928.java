import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon16928 {
    public static int n,m;
    public static int[] arr, stairs, snakes;
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public void Baekjoon16928() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr =  new int[101];
        stairs =  new int[101];
        snakes =  new int[101];

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            stairs[x] = y;
        }
        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            snakes[x] = y;
        }
        bfs();
//        System.out.println(Arrays.toString(arr));
        bw.write(String.valueOf(arr[100]-1));
        bw.close();

    }

    public static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        int now;
        int next;
        q.offer(1);
        arr[1] = 1;
        while (!q.isEmpty()) {
            now = q.poll();
            if (now == 100) break;
            for (int i=1; i<=6; i++) {
                next = now+i;
                if (next <= 100 && arr[next] == 0) {
                    if (stairs[next] != 0 && arr[stairs[next]]==0) {
                        arr[next] = arr[now] + 1;
                        next = stairs[next];
                        arr[next] = arr[now] + 1;
                        q.offer(next);
                    }
                    else if (snakes[next] != 0 && arr[snakes[next]]==0) {
                        arr[next] = arr[now] + 1;
                        next = snakes[next];
                        arr[next] = arr[now] + 1;
                        q.offer(next);
                    }
                    else if (stairs[next] == 0 && snakes[next] == 0){
                        arr[next] = arr[now] + 1;
                        q.offer(next);
                    }
                }
            }
        }

    }
}
