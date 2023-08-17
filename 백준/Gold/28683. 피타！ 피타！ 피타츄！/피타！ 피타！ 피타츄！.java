import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
        long sum = 0;
        
        //N이 제곱수일 경우
        if (isSquareNumber(N)) {
            System.out.print(-1);
            return;
        }
        //N이 제곱수가 아닐 경우 
        else {
            // N 이 빗변인경우
        	// 검사해야할 범위는 루트N/루트2 만큼임.
            for (long i = 1; i <= (long)Math.sqrt(N*2)/2; i++) {
                long j = N - i * i;
                if (isSquareNumber(j)) {
                    sum++;
                }
            }
            
            // N 이 빗변이 아닌경우
            // -> N = B^2 - A^2 
            // -> N = (B+A)(B-A)
            // 두수의 곱이면 약수로 볼수도 있다.
            // ex) 8 = 8*1, 4*2
            // B+A, B-A 전부 짝수이거나 홀수이어야함. 
            // ex) 4 = 3+1, 2 = 3-1;
            // 둘다 짝수이거나, 홀수이면 둘을 더했을때 항상 짝수가 나옴.
            for (long i = 1; i <= (long)Math.sqrt(N); i++) {
                if (N % i == 0) {
                    if ((i + (N / i)) % 2 == 0) {
                        sum++;
                    }
                }
            }
        }
        System.out.println(sum);
    }

    public static boolean isSquareNumber(long num) {
        long sqrt = (long) Math.sqrt(num);
        return sqrt * sqrt == num;
    }
}