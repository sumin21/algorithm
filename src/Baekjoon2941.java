import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Baekjoon2941 {
    public int Baekjoon2941(String str) {
        List<String> arr = new ArrayList<>(Arrays.asList("c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="));
        int result = 0;
        int size = arr.size();
        boolean pass = false;

        for(int i=0; i<size; i++) {
            pass = false;
            String strInArr = arr.get(i);
            int strInArrSize = strInArr.length();

            if (str.length() == 0) break;

            if (str.length() >= strInArrSize && strInArr.equals(str.substring(0, strInArrSize))) {
                // 문자 동일
                    pass = true;
                    result++;

                    str = str.substring(strInArrSize);

                    i = -1;
            }

            if (!pass && i == size-1) {
                result++;
                str = str.substring(1);

                i = -1;

            }
        }

        return result;
    }
}
