import java.util.*;

public class Program미로탈출 {

    int[][] dist;
    int[][] diffs = new int[][] {{-1,0},{1,0},{0,-1},{0,1}};
    int n,m;
    public int solution(String[] maps) {
        int answer = 0;
        n = maps.length;
        m = maps[0].length();
        dist = new int[n][m];

        int[] start = new int[2];
        int[] mid = new int[2];
        int[] end = new int[2];

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if(maps[i].charAt(j)=='S') {
                    start[0] = i;
                    start[1] = j;
                }
                else if(maps[i].charAt(j)=='L') {
                    mid[0] = i;
                    mid[1] = j;
                }
                else if(maps[i].charAt(j)=='E') {
                    end[0] = i;
                    end[1] = j;
                }
            }
        }
        int res1 = bfs(start, 'L', maps);
        if (res1 == -1) return -1;

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                dist[i][j] = 0;
            }
        }
        int res2 = bfs(mid, 'E', maps);
        if (res2 == -1) return -1;
        return res1+res2-2;
    }
    public int bfs(int[] s, char goal, String[] maps) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(s);
        dist[s[0]][s[1]] = 1;

        while(!q.isEmpty()) {
            int[] now = q.poll();
            if (maps[now[0]].charAt(now[1])==goal) return dist[now[0]][now[1]];
            for (int[] diff : diffs) {
                int nextX = now[0]+diff[0];
                int nextY = now[1]+diff[1];
                if (nextX >=0 && nextX<n && nextY >=0 && nextY <m && maps[nextX].charAt(nextY)!='X' && dist[nextX][nextY]==0) {
                    q.offer(new int[] {nextX, nextY});
                    dist[nextX][nextY] = dist[now[0]][now[1]]+1;
                }
            }
        }
        return -1;
    }
}
