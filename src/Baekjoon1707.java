import java.io.*;
import java.util.*;

public class Baekjoon1707 {
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int t,v,e;
    public static boolean result;
    public static List<Integer>[] arr;
    public static int[] arr2;
    public static boolean[] visit;
    public void Baekjoon1707() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        for (int i=0; i<t; i++) {
            result = true;
            StringTokenizer st = new StringTokenizer(br.readLine());
            v = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            arr = new ArrayList[v+1];
            arr2 = new int[v+1];
            visit = new boolean[v+1];
            for (int j=1; j<=v; j++) {
                arr[j] = new ArrayList<>();
            }
            for (int j=0; j<e; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                arr[a].add(b);
                arr[b].add(a);
            }
            for (int j=1; j<=v; j++) {
                if (!visit[j] && !bfs(j)) {
                    result= false;
                    break;
                }
            }
            bw.write(result ? "YES" : "NO");
            bw.newLine();
        }
        bw.close();
    }

    public static boolean bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visit[start] = true;
        arr2[start] = 1;
        while (!q.isEmpty()) {
            int now = q.poll();
            int color = arr2[now];
            int newColor = (color%2==1) ? 2 : 1;
            for (int i : arr[now]) {
                if (!visit[i]) {
                    arr2[i] = newColor;
                    visit[i] = true;
                    q.offer(i);
                } else if (visit[i] && arr2[i] != newColor) {
                    return false;
                }
            }
        }
        return true;
    }
}
