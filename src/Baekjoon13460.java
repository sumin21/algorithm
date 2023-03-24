import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon13460 {
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static class Position {
        int rx;
        int ry;
        int bx;
        int by;
        char p;
        int num;
        Position(int rx, int ry, int bx, int by, char p, int num) {
            this.rx = rx;
            this.ry = ry;
            this.bx = bx;
            this.by = by;
            this.p = p;
            this.num = num;
        }
    }
    public static int n,m,rx,ry,bx,by,ox,oy;
    public static char[][] arr;
    public void Baekjoon13460() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new char[n][m];
        for (int i=0; i<n; i++) {
            String str = br.readLine();
            for (int j=0; j<m; j++) {
                arr[i][j] = str.charAt(j);
                if (arr[i][j] == 'R') {
                    rx = i;
                    ry = j;
                } else if (arr[i][j] == 'B') {
                    bx = i;
                    by = j;
                } else if (arr[i][j] == 'O') {
                    ox = i;
                    oy = j;
                }
            }
        }
        bfs();
        bw.close();
    }

    public static void bfs() throws IOException{
        Queue<Position> q = new LinkedList<>();
        q.offer(new Position(rx,ry,bx,by,'위',0));
        q.offer(new Position(rx,ry,bx,by,'아',0));
        q.offer(new Position(rx,ry,bx,by,'왼',0));
        q.offer(new Position(rx,ry,bx,by,'오',0));

        while (!q.isEmpty()) {
            Position now = q.poll();
            int[] red = new int[] {now.rx, now.ry};
            int[] blue = new int[] {now.bx, now.by};
            boolean isBlue = false;
            boolean isRed = false;


            int[] rend = new int[2];
            int[] bend = new int[2];
            boolean isRedFirst = false;
            int[] diff = new int[] {0,0};

            if (now.p == '위') {
                isRedFirst = red[0] < blue[0];
                diff[0] = 1;

                while (true) {
                    if (arr[red[0]][red[1]] == 'O') {
                        isRed = true;
                        break;
                    } else if (arr[red[0]][red[1]] == '#') {
                        rend[0] = red[0]+1;
                        rend[1] = red[1];
                        break;
                    }
                    red[0]--;
                }
                while (true) {
                    if (arr[blue[0]][blue[1]] == 'O') {
                        isBlue = true;
                        break;
                    } else if (arr[blue[0]][blue[1]] == '#') {
                        bend[0] = blue[0]+1;
                        bend[1] = blue[1];
                        break;
                    }
                    blue[0]--;
                }
            }
            if (now.p == '아') {
                isRedFirst = red[0] > blue[0];
                diff[0] = -1;
                while (true) {
                    if (arr[red[0]][red[1]] == 'O') {
                        isRed = true;
                        break;
                    } else if (arr[red[0]][red[1]] == '#') {
                        rend[0] = red[0]-1;
                        rend[1] = red[1];
                        break;
                    }
                    red[0]++;
                }
                while (true) {
                    if (arr[blue[0]][blue[1]] == 'O') {
                        isBlue = true;
                        break;
                    } else if (arr[blue[0]][blue[1]] == '#') {
                        bend[0] = blue[0]-1;
                        bend[1] = blue[1];
                        break;
                    }
                    blue[0]++;
                }
            }
            if (now.p == '왼') {
                isRedFirst = red[1] < blue[1];
                diff[1] = 1;

                while (true) {
                    if (arr[red[0]][red[1]] == 'O') {
                        isRed = true;
                        break;
                    } else if (arr[red[0]][red[1]] == '#') {
                        rend[0] = red[0];
                        rend[1] = red[1]+1;
                        break;
                    }
                    red[1]--;
                }
                while (true) {
                    if (arr[blue[0]][blue[1]] == 'O') {
                        isBlue = true;
                        break;
                    } else if (arr[blue[0]][blue[1]] == '#') {
                        bend[0] = blue[0];
                        bend[1] = blue[1]+1;
                        break;
                    }
                    blue[1]--;
                }
            }if (now.p == '오') {
                isRedFirst = red[1] > blue[1];
                diff[1] = -1;

                while (true) {
                    if (arr[red[0]][red[1]] == 'O') {
                        isRed = true;
                        break;
                    } else if (arr[red[0]][red[1]] == '#') {
                        rend[0] = red[0];
                        rend[1] = red[1]-1;
                        break;
                    }
                    red[1]++;
                }
                while (true) {
                    if (arr[blue[0]][blue[1]] == 'O') {
                        isBlue = true;
                        break;
                    } else if (arr[blue[0]][blue[1]] == '#') {
                        bend[0] = blue[0];
                        bend[1] = blue[1]-1;
                        break;
                    }
                    blue[1]++;
                }
            }

            if (rend[0] == bend[0] && rend[1] == bend[1]) {
                if (isRedFirst) {
                    red[0] = rend[0];
                    red[1] = rend[1];
                    blue[0] = bend[0]+diff[0];
                    blue[1] = bend[1]+diff[1];
                }
                else {
                    red[0] = rend[0]+diff[0];
                    red[1] = rend[1]+diff[1];
                    blue[0] = bend[0];
                    blue[1] = bend[1];
                }
            } else {
                red[0] = rend[0];
                red[1] = rend[1];
                blue[0] = bend[0];
                blue[1] = bend[1];
            }


            if (!isBlue && isRed) {
                bw.write(String.valueOf(now.num+1));
                return;
            }
            else if (!isBlue && !(now.rx == red[0] && now.ry == red[1]&& now.bx == blue[0]&& now.by == blue[1])) {
                if (now.num > 9) {
                    bw.write("-1");
                    return;
                }

                if (now.p != '위') q.offer(new Position(red[0],red[1], blue[0],blue[1], '위', now.num+1));
                if (now.p != '아') q.offer(new Position(red[0],red[1], blue[0],blue[1], '아', now.num+1));
                if (now.p != '왼') q.offer(new Position(red[0],red[1], blue[0],blue[1], '왼', now.num+1));
                if (now.p != '오') q.offer(new Position(red[0],red[1], blue[0],blue[1], '오', now.num+1));
            }
        }

        bw.write("-1");
    }
}
