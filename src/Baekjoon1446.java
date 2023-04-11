import java.io.*;
import java.util.*;

class Diff {
    int start;
    int end;
    int cost;
    Diff(int start, int end, int cost) {
        this.start = start;
        this.end = end;
        this.cost = cost;
    }
}
public class Baekjoon1446 {
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int n,d;
    public static int result = 0;
    public static int[] dist;
    public static List<Diff> arr = new ArrayList<>();

    public void Baekjoon1446() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        dist = new int[d+1];
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr.add(new Diff(s,e,c));
        }
        Collections.sort(arr, new Comparator<Diff>() {
            @Override
            public int compare(Diff a, Diff b) {
                return a.start - b.start;
            }
        });

        dp();
        bw.write(String.valueOf(dist[d]));
        bw.close();

    }

    public static void dp () {
        Arrays.fill(dist, d+1);
        int i=0;
        dist[0] = 0;
        int lastStart = arr.get(0).start;
        for (int j=0; j<d; j++) {
            if (i<n && j==arr.get(i).start) {
                dist[j + 1] = Math.min(dist[j + 1], dist[j] + 1);
                while (i<n && lastStart == arr.get(i).start) {
                    if (arr.get(i).end <= d) dist[arr.get(i).end] = Math.min(dist[arr.get(i).end], dist[arr.get(i).start] + arr.get(i).cost);
                    i += 1;
                }
                if (i<n) lastStart = arr.get(i).start;
            } else {
                dist[j+1] = Math.min(dist[j+1], dist[j]+1);
            }

        }
    }
}
