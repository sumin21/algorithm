import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon7562 {
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int t,l;
    public static int[][] arr;
    public static int[][] points = new int[][] {{-2,-1},{-2,1},{-1,-2},{-1,2},{2,-1},{2,1},{1,-2},{1,2}};
    public void Baekjoon7562() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        for (int i=0; i<t; i++) {
            l = Integer.parseInt(br.readLine());
            arr = new int[l][l];
            int[] start = new int[2];
            int[] end = new int[2];
            StringTokenizer st = new StringTokenizer(br.readLine());
            start[0] = Integer.parseInt(st.nextToken());
            start[1] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            end[0] = Integer.parseInt(st.nextToken());
            end[1] = Integer.parseInt(st.nextToken());
            int result = bfs(start, end);
            bw.write(String.valueOf(result-1));
            bw.newLine();
        }
        bw.close();
    }

    public static int bfs(int[] start, int[] end) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(start);
        arr[start[0]][start[1]] = 1;
        while(!q.isEmpty()) {
            int[] point = q.poll();
            int num = arr[point[0]][point[1]];
            if(point[0] == end[0] && point[1] == end[1]) return num;
            for (int[] diff : points) {
                if (point[0]+diff[0]>=0 && point[0]+diff[0]<l && point[1]+diff[1]>=0 && point[1]+diff[1]<l && arr[point[0]+diff[0]][point[1]+diff[1]]==0) {
                    arr[point[0] + diff[0]][point[1] + diff[1]] = num + 1;
                    q.offer(new int[] {point[0] + diff[0], point[1] + diff[1]});
                }
            }
        }
        return -1;
    }
}
