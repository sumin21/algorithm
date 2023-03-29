import java.io.*;
import java.util.*;

public class Baekjoon1992 {
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int n;
    public static String result = "";
    public static boolean[][] arr;
    public void Baekjoon1992() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new boolean[n][n];
        for (int i=0; i<n; i++) {
            String s = br.readLine();
            for (int j=0; j<n; j++) {
                arr[i][j] = (s.charAt(j)=='1') ? true : false;
            }
        }
        result = solution(0,0,n);
        bw.write(result);
        bw.close();
    }

    public static String solution(int x, int y, int size) {
        String ele = arr[x][y] ? "1" : "0";

        if(isOne(x,y,size)) {
            return ele;
        }

        String ele1 = solution(x,y,size/2);
        String ele2 = solution(x,y+size/2,size/2);
        String ele3 = solution(x+size/2,y,size/2);
        String ele4 = solution(x+size/2,y+size/2,size/2);

        return "("+ele1+ele2+ele3+ele4+")";
    }

    public static boolean isOne(int x, int y, int size) {
        boolean ele = arr[x][y];

        for (int i=x; i<x+size; i++) {
            for (int j=y; j<y+size; j++) {
                if (arr[i][j] != ele) return false;
            }
        }

        return true;
    }
}
