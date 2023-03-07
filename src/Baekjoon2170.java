import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Baekjoon2170 {
    public static int n, max;
    public static int[][] arr;
    public static int sum = 0;
    public void Baekjoon2170() throws IOException {
        long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][2];
        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

//        Arrays.sort(arr, Comparator.comparingInt(o1 -> o1[0]));
        Arrays.sort(arr, new Comparator<int[]>() { //x좌표 오름차순 정렬. x좌표 같으면 y좌표 오름차순 정렬
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0])  return o1[1] - o2[1];
                else  return o1[0] - o2[0];
            }
        });
        max = arr[0][1];
        sum = max-arr[0][0];
        for (int j=1; j<n; j++) {
            int x = arr[j][0];
            int y = arr[j][1];

            if (max >= y) continue;
            if (j!=0 && max >= x) {
                sum += y-max;
                max = y;
            }
            else {
                max = y;
                sum += y-x;
            }
        }
        System.out.println(sum);
    }
}
