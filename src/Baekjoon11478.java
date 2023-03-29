import java.io.*;
import java.util.*;

public class Baekjoon11478 {
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int result = 0;
    public static int len;
    public static String str;
    public static HashMap<String,Integer> res = new HashMap<>();
    public static int[] arr;

    public void Baekjoon11478() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        len = str.length();
        solution();
//        bw.write(res.toString());
        bw.write(String.valueOf(result));
        bw.close();
    }

    public static void solution() {
        int start = 0;
        int end = 0;
        while (start < len) {
            if (start==end) {
                String s = String.valueOf(str.charAt(start));
                if(!res.containsKey(s)) {
                    result++;
                    res.put(s,1);
                }
            }
            else {
                String s = str.substring(start, end+1);
                if(!res.containsKey(s)) {
                    result++;
                    res.put(s,1);
                }
            }
            end++;
            if (end==len) {
                start++;
                end = start;
            }
        }

    }
}
