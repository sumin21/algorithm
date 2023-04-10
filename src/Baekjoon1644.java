import java.io.*;
import java.util.*;

public class Baekjoon1644 {
    public static int n;
    public static int[] arr;
    public static int result = 0;
    public static List<Integer> list = new ArrayList<>();
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public void Baekjoon1644() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        if (n != 1) {
            sosu();
            twoP(0, 0, list.size() - 1);
        }
        bw.write(String.valueOf(result));
        bw.close();

    }

    public static void sosu() {
        arr[0] = -1;
        arr[1] = -1;
        for (int i=2; i*i<=n; i++) {
            if (arr[i] != -1) {
                for (int j=i*2; j<=n; j+=i) {
                    arr[j] = -1;
                }
            }
        }

        for (int i=2; i<=n; i++) {
            if (arr[i] != -1) {
                list.add(i);
            }
        }
    }

    public static void twoP(int s, int e, int size) {
        int sum = list.get(s);
        while (s<=e && e<=size) {
            if (s==e) {
                if (sum == n) {
                    result += 1;
                    return;
                } else if (sum > n) return;
                else {
                    e++;
                    if (e <= size) sum += list.get(e);
                }
            } else if (sum < n) {
                e++;
                if (e <= size) sum += list.get(e);
            } else if (sum > n) {
                s++;
                sum -= list.get(s-1);
            } else {
                result +=1;
                s++;
                e++;
                sum -= list.get(s-1);
                if (e <= size) sum += list.get(e);
            }
        }
    }
}
