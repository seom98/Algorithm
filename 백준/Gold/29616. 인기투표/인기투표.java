import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.nextInt();
		long[] arr1 = new long[N];
		long[] arr2 = new long[N];
		for (int i = 0; i < N; i++) {
			arr1[i] = sc.nextInt();
		}
		for (int i = 0; i < N; i++) {
			arr2[i] = sc.nextInt();
		}
		long g1 = gcd(arr1);
		long g2 = gcd(arr2);
		long c1 = 0;
		long c2 = 0;
		for (int i = 0; i < N; i++) {
			arr1[i] /= g1;
			c1 += arr1[i];
		}
		for (int i = 0; i < N; i++) {
			arr2[i] /= g2;
		}
		long max = 1;
		for (int i = 0; i < N; i++) {
			long x = (long) Math.ceil((double) arr1[i] / arr2[i]);;
			if(max < x) 
				max = x;
		}
		for (int i = 0; i < N; i++) {
			arr2[i] *= max;
			c2 += arr2[i];
		}
		System.out.println(c1 + " " + c2);
		sc.close();
		
	}
	public static long gcd(long[] arr) {
	    long result = arr[0];
	    for (int i = 1; i < arr.length; i++) {
	        result = gcd(result, arr[i]);
	    }
	    return result;
	}

	public static long gcd(long a, long b) {
	    if (b == 0) return a;
	    return gcd(b, a % b);
	}
}