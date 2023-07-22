import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int num1 = sc.nextInt();
        int num2 = sc.nextInt();

        int a = num2 % 10;
        int b = (num2 % 100 - a) / 10;
        int c = (num2 - (num2 % 100)) / 100;

        System.out.println(num1 * a);
        System.out.println(num1 * b);
        System.out.println(num1 * c);
        System.out.println(num1 * a + num1 * b * 10 + num1 * c * 100);

    }
}