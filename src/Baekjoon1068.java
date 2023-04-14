import java.io.*;
import java.util.*;

public class Baekjoon1068 {
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int n;
    public static int result;
    public static int[] parents;
    public void Baekjoon1068() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        result = n;
        parents = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i=0; i<n; i++) {
            int input = Integer.parseInt(st.nextToken());
            parents[i] = input;
            if (!map.containsKey(i)) map.put(i, null);
            if (input == -1) continue;
            if (!map.containsKey(input)) {
                result -=1;
                map.put(input, new ArrayList<>());
                map.get(input).add(i);
            }
            else if (map.get(input) == null) {
                result -=1;
                map.put(input, new ArrayList<>());
                map.get(input).add(i);
            } else {
                map.get(input).add(i);
            }
        }
        int del = Integer.parseInt(br.readLine());
        if (parents[del] == -1) bw.write("0");
        else {
            if (map.get(parents[del]).size() == 1) result+=1;
            Queue<Integer> q = new LinkedList<>();
            q.offer(del);
            while(!q.isEmpty()) {
                int now = q.poll();
                if (map.get(now)==null) {
                    result -= 1;
                } else {
                    for (int child : map.get(now)) {
                        q.offer(child);
                    }
                }
            }

            bw.write(String.valueOf(result));
        }
        bw.close();
    }
}
