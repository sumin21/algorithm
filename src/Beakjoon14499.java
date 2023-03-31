import java.io.*;
import java.util.StringTokenizer;

public class Beakjoon14499 {
    public static int n,m,x,y,k;
    public static int[][] arr;
    public static int[] dice = new int[6];
    public static int [][] positions = new int[][] {{5,1,4,3,0,2}, {4,1,5,3,2,0}, {1,2,3,0,4,5}, {3,0,1,2,4,5}};
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public void Beakjoon14499() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n][m];

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());

        for (int i=0; i<k; i++) {
            int position = Integer.parseInt(st.nextToken());

            int result = solution(position);
            if (result == -1) continue;
            bw.write(String.valueOf(result));
            bw.newLine();
        }
        bw.close();
    }

    public static int solution(int position) {
        if (position == 1 && y+1>=m) return -1;
        if (position == 2 && y-1<0) return -1;
        if (position == 3 && x-1<0) return -1;
        if (position == 4 && x+1>=n) return -1;
        int[] po = positions[position-1];
        int[] newDice = new int[6];

        if (position == 1) y++;
        if (position == 2) y--;
        if (position == 3) x--;
        if (position == 4) x++;

        // dice update
        for (int i=0; i<6; i++) {
            newDice[i] = dice[po[i]];
        }
        for (int i=0; i<6; i++) {
            dice[i] = newDice[i];
        }

        // arr update
        if (arr[x][y] == 0) arr[x][y] = dice[0];
        else {
            dice[0] = arr[x][y];
            arr[x][y] = 0;
        }

        return dice[2];

    }
}
