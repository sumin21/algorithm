import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon12100 {
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int n;
    public static int max = 0;
    public static int[][] arr;

    public void Baekjoon12100() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] > max) max = arr[i][j];
            }
        }

        int[][] returnArr = new int[n][n];
        returnArr = dfs('왼',0);
        for (int i=0; i<n; i++) {
            arr[i] = returnArr[i].clone();
        }
        returnArr = dfs('위',0);
        for (int i=0; i<n; i++) {
            arr[i] = returnArr[i].clone();
        }
        returnArr = dfs('아',0);
        for (int i=0; i<n; i++) {
            arr[i] = returnArr[i].clone();
        }

        returnArr = dfs('오',0);
        for (int i=0; i<n; i++) {
            arr[i] = returnArr[i].clone();
        }
        bw.write(String.valueOf(max));
        bw.close();
    }

    public static int[][] dfs (char p, int idx){
        int[][] tempArr = new int[n][n];
        for (int i=0; i<n; i++) {
            tempArr[i] = arr[i].clone();
        }

        if (p == '위') {
            for (int i=0; i<n; i++) {
                int[] last = new int[] {0,0};
                boolean isFirst = true;
                boolean isChange = false;

                for (int j=0; j<n; j++) {
                    if (arr[j][i] != 0) { // 행
                        if (isFirst) {
                            arr[0][i] = arr[j][i]; //
                            if (j != 0) arr[j][i] = 0;
                            last[0] = 0; //
                            last[1] = i; //
                            isFirst = false;
                        } else if (arr[last[0]][last[1]] == arr[j][i] && !isChange) {
                            arr[j][i] = 0;
                            arr[last[0]][last[1]] *= 2;
                            if (arr[last[0]][last[1]] > max) max = arr[last[0]][last[1]];
                            isChange = true;
                        } else if (arr[last[0]][last[1]] != arr[j][i] || isChange) {
                            arr[last[0]+1][i] = arr[j][i]; //last행 +1 행 //
                            if (j != last[0]+1) arr[j][i] = 0;
                            last[0] += 1; //
                            last[1] = i; //
                            isChange = false;
                        }
                    }
                }
            }
        }
        if (p == '아') {
            for (int i=0; i<n; i++) {
                int[] last = new int[] {0,0};
                boolean isFirst = true;
                boolean isChange = false;

                for (int j=n-1; j>=0; j--) {
                    if (arr[j][i] != 0) { // 행
                        if (isFirst) {
                            arr[n-1][i] = arr[j][i]; //
                            if (j != n-1) arr[j][i] = 0;
                            last[0] = n-1; //
                            last[1] = i; //
                            isFirst = false;
                        } else if (arr[last[0]][last[1]] == arr[j][i] && !isChange) {
                            arr[j][i] = 0;
                            arr[last[0]][last[1]] *= 2;
                            if (arr[last[0]][last[1]] > max) max = arr[last[0]][last[1]];
                            isChange = true;
                        } else if (arr[last[0]][last[1]] != arr[j][i] || isChange) {
                            arr[last[0]-1][i] = arr[j][i];
                            if (j != last[0]-1) arr[j][i] = 0;
                            last[0] -= 1;
                            last[1] = i;
                            isChange = false;
                        }
                    }
                }
            }
        }
        if (p == '왼') {
            for (int j=0; j<n; j++) {
                int[] last = new int[] {0,0};
                boolean isFirst = true;
                boolean isChange = false;

                for (int i=0; i<n; i++) {
                    if (arr[j][i] != 0) {
                        if (isFirst) {
                            arr[j][0] = arr[j][i];
                            if (i != 0) arr[j][i] = 0;
                            last[0] = j; //
                            last[1] = 0; //
                            isFirst = false;
                        } else if (arr[last[0]][last[1]] == arr[j][i] && !isChange) {
                            arr[j][i] = 0;
                            arr[last[0]][last[1]] *= 2;
                            if (arr[last[0]][last[1]] > max) max = arr[last[0]][last[1]];
                            isChange = true;
                        } else if (arr[last[0]][last[1]] != arr[j][i] || isChange) {
                            arr[j][last[1]+1] = arr[j][i]; //last행 +1 행 //
                            if (i != last[1]+1) arr[j][i] = 0;
                            last[0] = j; //
                            last[1] += 1; //
                            isChange = false;
                        }
                    }
                }
            }
        }
        if (p == '오') {
            for (int j=0; j<n; j++) {
                int[] last = new int[] {0,0};
                boolean isFirst = true;
                boolean isChange = false;

                for (int i=n-1; i>=0; i--) {
                    if (arr[j][i] != 0) {
                        if (isFirst) {
                            arr[j][n-1] = arr[j][i];
                            if (i != n-1) arr[j][i] = 0;
                            last[0] = j; //
                            last[1] = n-1; //
                            isFirst = false;
                        } else if (arr[last[0]][last[1]] == arr[j][i] && !isChange) {
                            arr[j][i] = 0;
                            arr[last[0]][last[1]] *= 2;
                            if (arr[last[0]][last[1]] > max) max = arr[last[0]][last[1]];
                            isChange = true;
                        } else if (arr[last[0]][last[1]] != arr[j][i] || isChange) {
                            arr[j][last[1]-1] = arr[j][i];
                            if (i != last[1]-1) arr[j][i] = 0;
                            last[0] = j; //
                            last[1] -= 1; //
                            isChange = false;
                        }
                    }
                }
            }
        }
        System.out.println("idx = " + idx);
        System.out.println("p = " + p);
        System.out.println(Arrays.deepToString(arr));
        if (idx >= 4) {
            return tempArr;
        }
        int[][] returnArr = new int[n][n];
        returnArr = dfs('위', idx+1);
        for (int i=0; i<n; i++) {
            arr[i] = returnArr[i].clone();
        }

        returnArr = dfs('아', idx + 1);
        for (int i=0; i<n; i++) {
            arr[i] = returnArr[i].clone();
        }
        returnArr = dfs('왼', idx + 1);
        for (int i=0; i<n; i++) {
            arr[i] = returnArr[i].clone();
        }

        returnArr = dfs('오', idx + 1);
        for (int i=0; i<n; i++) {
            arr[i] = returnArr[i].clone();
        }


        return tempArr;
    }
}
