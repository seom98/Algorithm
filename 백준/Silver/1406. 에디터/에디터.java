import java.io.*;
import java.util.*;

//에디터 
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		LinkedList<Character> ll = new LinkedList<>();

		String str = br.readLine();
		int M = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < str.length(); i++) {
			ll.add(str.charAt(i));
		}

		ListIterator<Character> lit = ll.listIterator();
		
		while(lit.hasNext()) {
			lit.next();
		}

		while (M > 0) {
			String cmdstr = br.readLine();
			char cmd = cmdstr.charAt(0);
			
			switch (cmd) {
			case 'L':
				if(lit.hasPrevious())
					lit.previous();
				break;
			case 'D':
				if(lit.hasNext())
					lit.next();
				break;
			case 'B':
				if(lit.hasPrevious()) {
					lit.previous();
					lit.remove();
				}
				break;
			case 'P':
				char t = cmdstr.charAt(2);
				lit.add(t);
				break;
			}
			M--;
		}
		StringBuilder sb = new StringBuilder();
		for (Character chr : ll) {
			sb.append(chr);
		}
		System.out.print(sb);

		br.close();
	}
}
