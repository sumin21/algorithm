import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon4673 {
    public static int[] arr;
    public static int result;

    public void Baekjoon4673() throws IOException {
        arr = new int[10000];
        for (int j=1; j<=10000; j++) {
            arr[j-1] = j;
        }

        for (int i=0; i<10000; i++) {
            if (i < 10) {
                result = i + i;
            } else if (i < 100) {
                result = i + (i/10) + (i%10);
            } else if (i < 1000) {
                int k = i/100;
                result = i + k + (i - k*100)/10 + (i%10);
            } else {
                int k = i/1000;
                int kk = (i - k*1000)/100;
                result = i + k + kk + (i - k*1000 - kk*100)/10 + (i%10);
            }

            arr = Arrays.stream(arr).filter(ele -> ele != result).toArray();
        }

        for (int resultEle : arr) {
            System.out.println(resultEle);
        }

    }


}
