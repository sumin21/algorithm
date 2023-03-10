import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Baekjoon1987 {
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int r,c;
    public static int max = 0;
    public static boolean[][] visit;
    public static char[][] arr;
    public static List<Character> alph = new ArrayList<>();
    public void Baekjoon1987() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        visit = new boolean[r][c];
        arr = new char[r][c];

        for (int i=0; i<r; i++) {
            String s = br.readLine();
            for (int j=0; j<c; j++) {
                arr[i][j] = s.charAt(j);
            }
        }
        dfs(0,0);
        bw.write(String.valueOf(max));
        bw.close();
    }

    public static void dfs(int a, int b) throws IOException{
        visit[a][b] = true;
        alph.add(arr[a][b]);
        boolean posible = false;


        if (a>0 && !visit[a-1][b] && !alph.contains(arr[a-1][b])) { //위
            posible = true;
            dfs(a-1, b);
            visit[a-1][b] = false;
            alph.remove((Character) arr[a-1][b]);
        }
        if (a<r-1 && !visit[a+1][b] && !alph.contains(arr[a+1][b])) {//아
            posible = true;
            dfs(a+1, b);
            visit[a+1][b] = false;
            alph.remove((Character) arr[a+1][b]);
        }
        if (b>0 && !visit[a][b-1] && !alph.contains(arr[a][b-1])) {//왼
            posible = true;
            dfs(a, b-1);
            visit[a][b-1] = false;
            alph.remove((Character) arr[a][b-1]);
        }
        if (b<c-1 && !visit[a][b+1] && !alph.contains(arr[a][b+1])) {//오
            posible = true;
            dfs(a, b+1);
            visit[a][b+1] = false;
            alph.remove((Character) arr[a][b+1]);
        }

        if (!posible) {
            if (max < alph.size()) max = alph.size();
        }
        return;
    }
}
