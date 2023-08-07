import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] arr = new int[num];
        int count = sc.nextInt();
        for (int i = 0; i < num; i++) {
            arr[i] = sc.nextInt();
        }
        for(int i = 1; i < num; i++) {
            for(int j = 0; j < num - i; j++) {
                if(arr[j] > arr[j+1]) {
                    int temp;
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    count--;
                    if (count == 0) {
                    	for (int k = 0; k < num; k++) {
                    		System.out.print(arr[k] + " ");
                    	}
                        break;
                    }
                }
            }
        }
        if (count > 0) {
            System.out.print(-1);
        }
        sc.close();
    }
}
