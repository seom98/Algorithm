import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double X = sc.nextDouble();
        double Y = sc.nextDouble();
        double A = sc.nextDouble();


        double L = 0, R = Math.min(X, Y);

        while (R - L >= 0.001) {
            double width = (L + R) / 2;
            double h1 = Math.sqrt(Math.pow(X, 2) - Math.pow(width, 2));
            double h2 = Math.sqrt(Math.pow(Y, 2) - Math.pow(width, 2));
            double res = (h1 * h2) / (h1 + h2);
  
            if (res >= A) L = width;
            else R = width;
        }
        System.out.println(String.format("%.3f", R));
        sc.close();
    }
}