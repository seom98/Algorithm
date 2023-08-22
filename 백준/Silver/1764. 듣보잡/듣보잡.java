import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		HashSet<String> dbj = new HashSet<>();
	    int N = sc.nextInt();
	    int M = sc.nextInt();
	    for (int i = 0; i < N; i++) {
	    	dbj.add(sc.next());
	    }
	    
	    List<String> li = new ArrayList<>();
	    int count = 0;
	    for (int i = 0; i < M; i++) {
	    	String dbdb = sc.next();
	    	if (dbj.contains(dbdb)) {
	    		li.add(dbdb);
	    		count++;
	    	}
	    }
	    Collections.sort(li);
	    System.out.println(count);
	    for (String a : li) {
	    	System.out.println(a);
	    }
	}
}