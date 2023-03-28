
import java.util.*;

public class Program베스트엘범 {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer;
        int oneLen = 0;
        HashMap<String, int[]> map = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        for (int i=0; i<genres.length; i++) {
            if (map.containsKey(genres[i])) {
                int[] play = map.get(genres[i]);
                play[2] += plays[i];
                if (plays[play[0]] == plays[i]) play[1] = i;
                else if (plays[play[0]] < plays[i]) {
                    play[1] = play[0];
                    play[0] = i;
                }
                else if (play[1] == -1 || plays[play[1]] < plays[i]) play[1] = i;

            } else {
                map.put(genres[i], new int[] {i,-1, plays[i]});
            }
        }

        List<String> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                int aSum = map.get(a)[2];
                int bSum = map.get(b)[2];
                return bSum - aSum;
            }
        });

        for (String s: map.keySet()) {
            if (map.get(s)[1]==-1) oneLen++;
            System.out.println(map.get(s)[2]);
        }

        System.out.println(keys);
        int len = keys.size() * 2;
        answer = new int[len-oneLen];
        int ii=-1;
        for (int i=0; i<keys.size(); i++) {
            ii++;
            answer[ii] = map.get(keys.get(i))[0];
            if (map.get(keys.get(i))[1] == -1) continue;
            ii++;
            answer[ii] = map.get(keys.get(i))[1];
        }

        return answer;
    }
}