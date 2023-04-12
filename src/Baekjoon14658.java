import java.io.*;
import java.util.*;

public class Baekjoon14658 {
    public static int n,m,l,k;
    public static int result = 0;
    public static boolean[] visited;
    public static List<int[]> arr = new ArrayList<>();
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public void Baekjoon14658() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        for (int i=0; i<k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr.add(new int[] {a,b});
        }

        for (int i=0; i<k; i++) {

            for (int j=0; j<k; j++) {
                int star = solution(arr.get(i)[0], arr.get(j)[1]);
                result = Math.max(result, star);
            }
        }

        bw.write(String.valueOf(k-result));
        bw.close();
    }

    public static int solution(int x, int y) {
        int[] p1 = new int[] {x, y};
        int[] p2 = new int[] {x+l,y+l};
        int res = 0;
        if (p2[0]>=1 && p2[0]<=n && p2[1]>=1 && p2[1]<=m ){
            for (int j=0; j<k; j++) {
                if (arr.get(j)[0] >= p1[0] && arr.get(j)[0]<=p2[0] && arr.get(j)[1] >= p1[1] && arr.get(j)[1] <=p2[1]) {
                    res +=1;
                }
            }
        }
        return res;
    }
}
