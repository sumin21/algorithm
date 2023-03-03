import java.util.Scanner;
public class Main {
    public static void main(String[] ars) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        Baekjoon2941 algorithm = new Baekjoon2941();
        int result = algorithm.Baekjoon2941(str);
        System.out.println(result);
    }
}