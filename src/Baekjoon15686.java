import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon15686 {
    public static int inputN, inputM;
    public static int[][] inputArr, homeArr, chickenArr, comChickenArr;
    public static int homeNum, chickenNum, resultDistance, resultMinDistance = 0;

    public void Baekjoon15686() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        inputN = Integer.parseInt(st.nextToken());
        inputM = Integer.parseInt(st.nextToken());
        inputArr = new int[inputN][inputN];

        homeArr = new int[inputN*inputN][2];
        chickenArr = new int[inputN*inputN][2];
        comChickenArr = new int[inputM][2];

        for (int i=0; i<inputN; i++) { // 필요?
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<inputN; j++) {
                int inputInt = Integer.parseInt(st.nextToken());
                inputArr[i][j] = inputInt;
                if (inputInt == 1) {
                    homeArr[homeNum][0] = i;
                    homeArr[homeNum][1] = j;
                    homeNum++;
                } else if (inputInt == 2) {
                    chickenArr[chickenNum][0] = i;
                    chickenArr[chickenNum][1] = j;
                    chickenNum++;
                }
            }
        }

        if (chickenNum > inputM) {
            // 조합
            resultMinDistance = -1;
            combination(0,0);
        } else {
            // chickenArr.length == inputM
            for (int point=0; point<inputM; point++) {
                comChickenArr[point] = chickenArr[point];
            }
            getMinDistance();
            resultMinDistance = resultDistance;
        }

        System.out.println(resultMinDistance);
    }

    // chickenNum C inputM
    public static void combination(int a, int b) {
        if (b == inputM) {
            // 끝 -> 2번
            getMinDistance();
            if (resultMinDistance == -1 || resultMinDistance > resultDistance) resultMinDistance = resultDistance;
            resultDistance = 0;
            return;
        }

        for (int i=a; i<chickenNum; i++) {
            comChickenArr[b] = chickenArr[i];
            combination(i+1, b+1);
        }
    }

    public static void getMinDistance() {
        // comChickenArr 이용
        for (int i=0; i<homeNum; i++) {
            int[] homePoint = homeArr[i];
            int min = -1;
            for (int[] chickenPoint : comChickenArr) {
                int distance1, distance2, distance;
                if (homePoint[0] > chickenPoint[0]) {
                    distance1 = homePoint[0] - chickenPoint[0];
                } else distance1 = chickenPoint[0] - homePoint[0];

                if (homePoint[1] > chickenPoint[1]) {
                    distance2 = homePoint[1] - chickenPoint[1];
                } else distance2 = chickenPoint[1] - homePoint[1];

                distance = distance1 + distance2;
                if (min == -1 || min > distance) min = distance;
            }
            resultDistance += min;
        }
    }
}
