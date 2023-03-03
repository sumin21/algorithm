import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon1316 {
    public int Baekjoon1316() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result = 0;
        int num = Integer.parseInt(br.readLine()); // string -> int

        for (int i=0; i<num; i++) {
            String str = br.readLine();
            int size = str.length();
            List<Character> alphas = new ArrayList<Character>();
            alphas.add(str.charAt(0));
            char last = str.charAt(0);

            for (int j=0; j<size; j++) {
                char c = str.charAt(j);
                if (alphas.contains(c) && last != c) break;
                else if (!alphas.contains(c) && last != c) {
                    alphas.add(c);
                    last = c;
                }

                if (j == size-1) {
                    result++;
                }
            }
        }

        return result;
    }
}
