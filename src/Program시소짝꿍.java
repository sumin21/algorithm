import java.util.*;

public class Program시소짝꿍 {
    public long solution(int[] weights) {
        long answer = 0;
        HashMap<Integer, Long> map = new HashMap<>();
        for (int w : weights) {
            map.put(w, map.containsKey(w) ? map.get(w) + 1 : 1);
        }
        System.out.println(map);
        for (Integer key : map.keySet()) {
            System.out.println(key);

            Long val = map.get(key);

            if (map.get(key) > 1) answer += (val * (val - 1) / 2);
            if (map.containsKey(key * 2)) {
                System.out.println(111);
                answer += (map.get(key) * map.get(key * 2));
            }

            if (key % 2 == 0 && map.containsKey(key / 2 * 3)) {
                System.out.println(222);
                answer += (map.get(key) * map.get(key / 2 * 3));
            }
            if (key % 3 == 0 && map.containsKey(key / 3 * 4)) {
                System.out.println(333);
                answer += (map.get(key) * map.get(key / 3 * 4));
            }

            System.out.println(answer);

        }

        return answer;
    }
}
