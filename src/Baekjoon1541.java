import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon1541 {
    public static int n, result, strLen = 0;
    public static boolean[] minusArr = new boolean[50];
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static List<Integer> list = new ArrayList<>();
    public static boolean isMinus = false;

    public void Baekjoon1541() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputStr = br.readLine();
        if (inputStr.charAt(0) == '-') {
            minusArr[0] = true;
            inputStr = inputStr.substring(1);
        }
        String[] inputStrArr = inputStr.split("-");

        for (String str : inputStrArr) {
            String[] strs = str.split("\\+");
            if (strLen != 0) minusArr[strLen] = true;
            strLen += strs.length;
            for (String ele: strs) {
                list.add(Integer.parseInt(ele));
            }
        }
        n = list.size();

        for (int i=0; i<n; i++) {
            boolean minusEle = minusArr[i];
            if (minusEle && !isMinus) {
                result -= list.get(i);
                isMinus =true;
            }
            else if (!minusEle && isMinus) result -= list.get(i);
            else if (minusEle && isMinus) {
                result -= list.get(i);
            }
            else if (!minusEle && !isMinus) result += list.get(i);
        }

        bw.write(String.valueOf(result));
        bw.close();
    }
}
