import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); //테스트케이스의 개수.
         
        for (int tc = 1; tc<=t; tc++) {
        	
        	String memori = sc.next(); //메모리를 한줄로 받아준다. 
        	
        	
        	//몇번째에서 첫번째로 1이 나오는지 확인한다. 0이면 바꿀 필요가 없기 때문에.
        	int num = 0;
        	int count = 1; //첫번째로 1이 나올때 한번 카운트.
        	for (int i = 0; i < memori.length(); i++) {
        		if (memori.charAt(i) == '1') {
        			num = i;
        			break;
        		}
        	}
        	
        	//앞에 있는 문자와 다를때 마다 바꿔야하기 때문에 카운트를 해준다.
        	for (int i = num; i < memori.length()-1; i++) {
        		if (memori.charAt(i) != memori.charAt(i+1)) {
        			count++;
        		}
        	}
        	
        	System.out.println("#" + tc + " " + count); //출력 
        }
        sc.close();
	}
}