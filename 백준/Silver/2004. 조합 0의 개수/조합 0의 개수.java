import java.util.*;

public class Main {


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int L = N-M;
		int[] list = new int[] {5, 25, 125, 625, 3125, 15625, 78125, 
				390625, 1953125, 9765625, 48828125, 244140625, 1220703125};

		int a=0, b=0, c=0;
		for(int i = 0; i < 13; i++) {
			if (list[i] <= N) a += N / list[i];
			if (list[i] <= M) b += M / list[i];
			if (list[i] <= L) c += L / list[i];
		}
		int d=0, e=0, f=0;
		int[] list2 = new int[] {2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 131072, 262144, 524288, 1048576, 2097152, 4194304, 8388608, 16777216, 33554432, 67108864, 134217728, 268435456, 536870912, 1073741824};
		for (int i = 0; i < 30; i++) {
			if (list2[i] <= N) d += N / list2[i];
			if (list2[i] <= M) e += M / list2[i];
			if (list2[i] <= L) f += L / list2[i];
		}
		System.out.println(a-b-c <= d-e-f ? a-b-c : d-e-f);
	}
}