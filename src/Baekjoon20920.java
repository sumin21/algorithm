import java.io.*;
import java.util.*;

public class Baekjoon20920 {
    public static int n,m;
    public static int idx =1;
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public void Baekjoon20920() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashMap<String,Integer> map = new HashMap();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i=0; i<n; i++) {
            String s = br.readLine();
            if (s.length() < m) continue;

            if (!map.containsKey(s)) {
                map.put(s, idx);
                idx = 1;
            } else {

                int num = map.get(s);
                map.put(s, num+1);
            }
        }
        List<Map.Entry<String,Integer>> lists = new ArrayList<Map.Entry<String,Integer>>(map.entrySet());

        Collections.sort(lists, new Comparator<>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o1.getValue() != o2.getValue()) {
                    return o2.getValue()-o1.getValue();
                }
                else if (o1.getKey().length() != o2.getKey().length()) {
                    return o2.getKey().length() - o1.getKey().length();
                }
                else return o1.getKey().compareTo(o2.getKey());
            }
        });

        for(Map.Entry<String, Integer> entry : lists){
            bw.write(entry.getKey());
            bw.newLine();
        }
        bw.close();
    }
}
