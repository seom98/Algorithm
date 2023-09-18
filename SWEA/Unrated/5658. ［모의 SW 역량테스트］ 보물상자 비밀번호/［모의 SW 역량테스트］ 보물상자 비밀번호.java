import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			String s = sc.next();
			String str = s + s.substring(0, N/4);
			Set<String> set = new HashSet<>();
			for(int i = 0; i < N/4; i++) {
					set.add(str.substring(i+N*0/4, i+N*1/4));
					set.add(str.substring(i+N*1/4, i+N*2/4));
					set.add(str.substring(i+N*2/4, i+N*3/4));					
					set.add(str.substring(i+N*3/4, i+N*4/4));
			}
			
			List<String> arr = new ArrayList<>(set);
			
			Collections.sort(arr,Collections.reverseOrder());
			
			String hex = arr.get(K-1);
	        int ans = Integer.parseInt(hex, 16);
			System.out.println("#" + t + " " + ans);
		}

	}

}