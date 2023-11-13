import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h1 = sc.nextInt();
        int h2 = sc.nextInt();
        int h3 = sc.nextInt();
        int c1 = sc.nextInt();
        int c2 = sc.nextInt();
        System.out.println(Math.min(h1, Math.min(h2, h3)) + Math.min(c1, c2) - 50);
    }
}