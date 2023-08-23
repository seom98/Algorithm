import java.util.Scanner;

public class Solution{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			int N = sc.nextInt(); //숫자갯수
			sc.nextLine();
			char[] arr = new char[N+1]; //처음은 공백으로 둠 (왜두는지 모르겠으니까 아는사람 나한테 와서 알려주셈ㅠ)
			arr[0] = ' ';
			for (int i = 1; i < N+1; i++) {
				String[] a = sc.nextLine().split(" ");
				arr[i] = a[1].charAt(0);
			}
			System.out.print("#" + tc + " ");
			inorder(1, N+1, arr); //스태틱으로 선언하면 1만 적어도 되는데 어떻게 하는지 몰라서 그냥 다 파라미터로 넘김.
			System.out.println();
		}
	}
	//중위 순회
	public static void inorder(int i, int N, char[] arr) {
		if(i < N) {
			inorder(i*2, N, arr); // L
			if(arr[i] != ' ')
				System.out.print(arr[i]); //V
			inorder(i*2+1, N, arr); //R
		}
	}
}
