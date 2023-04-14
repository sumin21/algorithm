import java.io.*;
import java.util.*;

public class Baekjoon7682 {
    public static int max = 1;
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public void Baekjoon7682() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            String s = br.readLine();
            if (s.equals("end")) break;
            HashSet<Integer> set = new HashSet<>();
            int xNum = 0;
            int oNum = 0;
            boolean xWin = false;
            boolean oWin = false;
            for (int i=0; i<9; i++) {
                char c = s.charAt(i);
                if (c == 'X') {
                    xNum += 1;
                    if (i==2 | i==5 || i==8) {
                        if (s.charAt(i-2) == c && s.charAt(i-1) == c) {
                            xWin = true;
                            set.add(i);
                            set.add(i-1);
                            set.add(i-2);
                        }
                    } if (i==6 | i==7 || i==8) {
                        if (s.charAt(i-6) == c && s.charAt(i-3) == c) {
                            xWin = true;
                            set.add(i);
                            set.add(i-3);
                            set.add(i-6);
                        }
                    } if (i==8) {
                        if (s.charAt(0) == c && s.charAt(4) == c) {
                            xWin = true;
                            set.add(i);
                            set.add(0);
                            set.add(4);
                        }
                    } if (i==6) {
                        if (s.charAt(2) == c && s.charAt(4) == c) {
                            xWin = true;
                            set.add(i);
                            set.add(2);
                            set.add(4);
                        }
                    }

                }
                if (c == 'O') {
                    oNum += 1;
                    if (i==2 | i==5 || i==8) {
                        if (s.charAt(i-2) == c && s.charAt(i-1) == c) {
                            oWin = true;
                            set.add(i);
                            set.add(i-1);
                            set.add(i-2);
                        }
                    } if (i==6 | i==7 || i==8) {
                        if (s.charAt(i-6) == c && s.charAt(i-3) == c) {
                            oWin = true;
                            set.add(i);
                            set.add(i-3);
                            set.add(i-6);
                        }
                    } if (i==8) {
                        if (s.charAt(0) == c && s.charAt(4) == c) {
                            oWin = true;
                            set.add(i);
                            set.add(0);
                            set.add(4);
                        }
                    } if (i==6) {
                        if (s.charAt(2) == c && s.charAt(4) == c) {
                            oWin = true;
                            set.add(i);
                            set.add(2);
                            set.add(4);
                        }
                    }
                }

            }
            if (xWin && oWin) sb.append("invalid").append("\n");
            else if ((xWin || oWin) && set.size() != 3 && set.size() != 5) sb.append("invalid").append("\n");
            else if (xWin && xNum != oNum+1) sb.append("invalid").append("\n");
            else if (oWin && xNum != oNum) sb.append("invalid").append("\n");
            else if (!xWin && !oWin && (xNum!=5 || oNum!=4)) sb.append("invalid").append("\n");
            else sb.append("valid").append("\n");

        }
        bw.write(String.valueOf(sb));
        bw.close();
    }
}
//XXOOOXXOX