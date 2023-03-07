import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

public class Baekjoon1759 {
    public static int inputL, inputN;
    public static char[] inputArr;
    public static char[] outputArr;

    public void Baekjoon1759() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        inputL = Integer.parseInt(st.nextToken());
        inputN = Integer.parseInt(st.nextToken());
        inputArr = new char[inputN];
        outputArr = new char[inputL];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<inputN; i++) {
            inputArr[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(inputArr);

        backTracking(0,0);
    }

    public static void backTracking(int a, int b) { //조합
        if (b == inputL) {
            if (validation()) {
                for (char resultC : outputArr) {
                    System.out.print(resultC);
                }
                System.out.println();
            }
            return;
        }

        for (int i=a; i<inputN; i++) {
            outputArr[b] = inputArr[i];
            System.out.println(Arrays.toString(outputArr));
            backTracking(i+1, b+1); // 중복 조합의 경우 -> backTracking(i,b+1)
        }
    }

    public static boolean validation() {
        int a = 0;
        int b = 0;
        for (int i=0; i<inputL; i++) {
            if (outputArr[i] == 'a' || outputArr[i] == 'e' || outputArr[i] == 'i' || outputArr[i] == 'o' || outputArr[i] == 'u') {
                a++;
            } else b++;
        }
        if (a>0 && b>1) {
            return true;
        } return false;
    }
}
