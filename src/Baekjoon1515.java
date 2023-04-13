import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon1515 {
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static String str;
    public static int result = 0;

    public void Baekjoon1515() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        int len = str.length();
        int last = (int) str.charAt(0) - 48;
        int num = last;
        for (int i=1; i<len; i++) {
            System.out.println("last = " + last);
            System.out.println("num = " + num);
            int x = (int) str.charAt(i) - 48;
            System.out.println("x = " + x);

            if (last >= x) {
                System.out.println(isNext(num+1, x));
                if (isNext(num+1, x)) num += 1;
                else {
                    int tmp = (num / 10 + 1);
                    if (isNext(tmp, x)) num = tmp*10;
                    else num = tmp*10 + x;
                }
            }
            else num = (num/10)*10 + x;
            last = x;
        }
        bw.write(String.valueOf(num));
        bw.close();
    }

    public static boolean isNext(int n, int i) { //n에 i존재??
        String s = String.valueOf(n);
        for (char c : s.toCharArray()) {
            if (((int) c)-48 == i) return true;
        }
        return false;
    }
}
