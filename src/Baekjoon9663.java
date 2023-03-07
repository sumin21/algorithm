import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon9663 {
    public static int n;
    public static int result = 0;
    public static int[] qArr;
    public void Baekjoon9663() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        qArr = new int[n];

        nQueen(0);
        System.out.println(result);
    }

    public static void nQueen(int idx) {
        if (idx == n) {
            result++;
            return;
        }

        for (int i=0; i<n; i++) {
            qArr[idx] = i;
            if (isPossible(idx)) {
                nQueen(idx + 1);
            }
        }
    }

    public static boolean isPossible(int idx) {
        for (int i=0; i<idx; i++) {
            int qColm = qArr[i];
            if (qColm == qArr[idx]) return false;
            else if ((qColm-qArr[idx]) == (i-idx) || (qColm-qArr[idx]) == -1 * (i-idx)) {
                return false;
            }
        }
        return true;
    }
}
