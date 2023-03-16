import java.io.*;
import java.util.*;

public class Baekjoon1697 {
    public static int n, k;
    public static int result = 0;
    public static int perOne = 3;
    public static int[] bool = new int[100001];
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public void Baekjoon1697() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        bfs();
        bw.close();
    }

    public static void bfs() throws IOException{
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);
        bool[n] = 1;

        while(!queue.isEmpty()) {
            int point = queue.poll();
            if (point == k) {
                bw.write(String.valueOf(bool[point]-1));
                break;
            };

            if (point-1 > -1 && point-1 <100001 && bool[point-1]==0) {
                queue.offer(point-1);
                bool[point-1] += bool[point]+1;
            }
            if (point+1 > -1 && point+1 <100001 && bool[point+1]==0) {
                queue.offer(point+1);
                bool[point+1] += bool[point]+1;
            }
            if (point*2 > -1 && point*2 <100001 && bool[point*2]==0) {
                queue.offer(point*2);
                bool[point*2] += bool[point]+1;
            }
        }
    }
}
