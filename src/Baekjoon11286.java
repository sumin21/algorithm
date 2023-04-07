import java.io.*;
import java.util.*;

public class Baekjoon11286 {
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int n;


    public void Baekjoon11286() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                if (Math.abs(a) == Math.abs(b)) return a - b;
                return Math.abs(a) - Math.abs(b);
            }
        });
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0){
                if (pq.isEmpty()) bw.write("0");
                else bw.write(String.valueOf(pq.poll()));
                bw.newLine();
            }
            else {
                pq.offer(num);
            }
        }

        bw.close();
    }

}
