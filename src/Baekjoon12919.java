import java.io.*;
import java.util.Stack;

public class Baekjoon12919 {
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public void Baekjoon12919() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String t = br.readLine();
        int res = dfs(t, s);
        bw.write(String.valueOf(res));
        bw.close();
    }

    public static int dfs (String str, String origin) {
        if (str.length() == origin.length()) {
            if (str.equals(origin)) return 1;
            return 0;
        }

        int r1 = 0;
        if (str.charAt(str.length()-1) == 'A') r1 = dfs(str.substring(0, str.length()-1), origin);
        int r2 = 0;
        if (str.charAt(0) == 'B') r2 = dfs(backing(str.substring(1)), origin);

        return (r1==1||r2==1) ?1 : 0;
    }

    public static String backing(String s) {
        Stack<Character> stack = new Stack<>();
        String newS = "";
        for (char c : s.toCharArray()) {
            stack.push(c);
        }
        while (!stack.isEmpty()) {
            newS += stack.pop();
        }
        return newS;
    }
}
