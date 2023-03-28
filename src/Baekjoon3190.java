import java.io.*;
import java.util.*;

public class Baekjoon3190 {
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int n,k,l;
    public static int result = 0; //초
    public static int len = 1;
    public static char[] positions = new char[10002];
    public static int[][] board;

    public void Baekjoon3190() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Arrays.fill(positions, 'A');

        n = Integer.parseInt(br.readLine());
        board = new int[n+1][n+1];
        k = Integer.parseInt(br.readLine());
        for (int i=0; i<k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            board[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = -1;
        }
        l = Integer.parseInt(br.readLine());
        for (int i=0; i<l; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            positions[Integer.parseInt(st.nextToken())] = st.nextToken().charAt(0);
        }

        solution();
        bw.write(String.valueOf(result));
        bw.close();
    }

    public static void solution() {
        int headX = 1;
        int headY = 1;
        int endX = 1;
        int endY = 1;
        board[1][1] = 4;
        int position = 4;
        while(true) {
            // now = result 초! (1~)
            // go? no?
            result++;
            System.out.println(result);

            if (positions[result-1] == 'L') {
                if (position==1) position = 3;
                else if (position==2) position = 4;
                else if (position==3) position = 2;
                else position = 1;
            }
            else if (positions[result-1] == 'D') {
                if (position==1) position = 4;
                else if (position==2) position = 3;
                else if (position==3) position = 1;
                else position = 2;
            }

            board[headX][headY] = position;


            if (position==1) headX--;
            if (position==2) headX++;
            if (position==3) headY--;
            if (position==4) headY++;
            if (headX==0 || headX==n+1 || headY==0 || headY==n+1 || board[headX][headY] > 0) {
                // X
                break;
            }
            // go -> head, end update (사과)
            // 다음으로 이동

            // go (o) -> end update

            // head update
            if (board[headX][headY]==0) {
                // apple X
                int endPosition = board[endX][endY];
                board[endX][endY] = 0;

                if (endPosition == 1) endX--;
                else if (endPosition == 2) endX++;
                else if (endPosition == 3) endY--;
                else if (endPosition == 4) endY++;
            }

            System.out.println(String.valueOf(headX)+","+String.valueOf(headY));
            System.out.println(String.valueOf(endX)+","+String.valueOf(endY));
            for (int i=0; i<board.length; i++) {
                System.out.println(Arrays.toString(board[i]));
            }
        }
    }
}
