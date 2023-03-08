import java.io.*;
import java.util.StringTokenizer;

public class Baekjoon15649 {
    public static int n,m;
    public static int[] resultArr;
    public static boolean[] visited;
    // system.out : 시간초과남
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public void Baekjoon15649() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        resultArr = new int[m];
        visited = new boolean[n];

        nmFunc(0);
        bw.close();
    }

    public static void nmFunc(int idx) throws IOException{
        if (idx == m) {
            for (int j=0; j<m; j++) {
                bw.write(resultArr[j] + " ");
            }
            bw.newLine();
            return;
        }

        for (int i=0; i<n; i++) {
            if (visited[i] == false) {
                visited[i] = true;
                resultArr[idx] = i+1;
                nmFunc(idx+1);
                visited[i] = false;
            }
        }
    }
}
