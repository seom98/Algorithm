public class Main {
	public static void main(String[] args) {
        int[] arr =new int[10000];
        for (int i=1; i<= 9999; i++) {
        	if (i + (i/1000) + ((i%1000)/100) + ((i%100)/10) + i%10 < 10000) {
        		arr[i + (i/1000) + ((i%1000)/100) + ((i%100)/10) + i%10] = 1;
        	}
        }
        for (int i=1; i<= 9999; i++) {
            if (arr[i] == 0) {
                System.out.println(i);
            }
        }
	}
}
