import java.io.*;
import java.util.*;

public class Baekjoon20006 {
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int p,m;
    public static int roomIdx = 0;
    public static ArrayList<ArrayList<String[]>> arr = new ArrayList<>();
    public void Baekjoon20006() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        p = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());


        for (int i=0; i<p ;i++) {
            st = new StringTokenizer(br.readLine());
            int score = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            if (!findRoom(name, score)) {
                createRoom(name, score);
            }
        }

        for (List<String[]> room : arr) {
            if (room.size() == m) bw.write("Started!");
            else bw.write("Waiting!");
            bw.newLine();
            Collections.sort(room, new Comparator<String[]>() {
                @Override
                public int compare(String[] o1, String[] o2) {
                    return o1[1].compareTo(o2[1]);
                }
            });

            for (String[] player : room) {
                bw.write(player[0] + " " + player[1]);
                bw.newLine();
            }
        }

        bw.close();
    }

    public static void createRoom(String p, int score) {
        arr.add(new ArrayList<>());
        arr.get(roomIdx).add(new String[] {String.valueOf(score), p});
        roomIdx += 1;
    }

    public static boolean findRoom(String p, int score) {
        for (List<String[]> room : arr) {
            int level = Integer.parseInt(room.get(0)[0]);
            if (room.size() < m && level-10 <= score && level+10 >= score) {
                room.add(new String[] {String.valueOf(score),p});
                return true;
            }
        }
        return false;
    }
}
