import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        for (int tc = 0; tc < 4; tc++) {
        	int[] N = new int[4];
            for (int i = 0; i< 4; i++) 
            	N[i] = sc.nextInt();
            int[] M = new int[4];
            for (int i = 0; i< 4; i++) 
            	M[i] = sc.nextInt();
            int[] a = new int[4];
            int[] b = new int[4];
            
            if (N[0] <= M[0]) {
            	for (int i = 0; i< 4; i++) {
            		a[i] = N[i];
            		b[i] = M[i];
            	}
            } else {
            	for (int i = 0; i< 4; i++) {
            		a[i] = M[i];
            		b[i] = N[i];
            	}
            }
            
            if (a[2] > b[0]) {
            	if (a[1] > b[1]) {
            		if (a[1] > b[3])
            			System.out.println("d");
            		else if (a[1] == b[3])
            			System.out.println("b");
            		else 
            			System.out.println("a");
            	} else {
            		if (a[3] > b[1])
            			System.out.println("a");
            		else if (a[3] == b[1])
            			System.out.println("b");
            		else 
            			System.out.println("d");
            	}
            } else if (a[2] == b[0]) {
            	if (a[1] > b[1]) {
            		if (a[1] > b[3])
            			System.out.println("d");
            		else if (a[1] == b[3])
            			System.out.println("c");
            		else 
            			System.out.println("b");
            	} else {
            		if (a[3] > b[1])
            			System.out.println("b");
            		else if (a[3] == b[1])
            			System.out.println("c");
            		else 
            			System.out.println("d");
            	}
            } else {
            	System.out.println("d");
            }
        }        
    }
}