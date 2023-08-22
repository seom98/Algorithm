import java.io.*; //BufferedReader, InputStreamReader, IOException 임포트 
import java.util.*; //StringTokenizer, LinkedList 임포트 

//암호문3 
public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int tc = 1; tc <= 10; tc++) { //테스트케이스는 10개.
			LinkedList<Integer> ll = new LinkedList<>(); //링크드리스트 선언.
			
			int N = Integer.parseInt(br.readLine()); //암호의 갯수.
			StringTokenizer st = new StringTokenizer(br.readLine(), " "); //암호를 받아줌.
			for (int i = 0; i < N; i++)
				ll.add(Integer.parseInt(st.nextToken())); //암호를 ll에 집어 넣음.
			
			int M = Integer.parseInt(br.readLine()); //명령의 갯수.
			StringTokenizer cmdst = new StringTokenizer(br.readLine(), " "); //명령을 받아줌.
			
			while (M > 0) { //명령을 다받을때까지 와일문 진행.
				String cmd = cmdst.nextToken(); //어떤명령인지 체크함. 
				if (cmd.equals("I")) { //명령이 I일 때.
					int idx = Integer.parseInt(cmdst.nextToken()); //인덱스를 받아줌.
					int count = Integer.parseInt(cmdst.nextToken()); //반복하는 횟수.
					for (int i = 0; i < count; i++)
						ll.add(idx++, Integer.parseInt(cmdst.nextToken())); //횟수만큼 인덱스 위치부터 한칸씩 늘려가면서 값을 추가해줌. 만약 ++을 지우고 idx만 적는다면 위치가 엉망이 될 수 있음.
				} else if (cmd.equals("D")) { //명령이 D일 때.
					int idx = Integer.parseInt(cmdst.nextToken()); //인덱스를 받아줌.
					int count = Integer.parseInt(cmdst.nextToken()); //반복하는 횟수.
					for (int i = 0; i < count; i++)
						ll.remove(idx); //인덱스의 위치부터 횟수만큼 값을 삭제함.
				} else if (cmd.equals("A")) { //명령이 A일 때.
					int count = Integer.parseInt(cmdst.nextToken()); //반복하는 횟수.
					for (int i = 0; i < count; i++)
						ll.add(Integer.parseInt(cmdst.nextToken())); //횟수만큼 값을 추가함.
				}
				M--; //한번의 명령이 끝났으므로 명령횟수에서 1 마이너스함.
			}
			StringBuilder sb = new StringBuilder();	//쉽게 출력하기 위해 스트링빌더 사용.
			for (int i = 0; i < 10; i++) //앞에서부터 10개만 출력해야하므로 10번 반복.
				sb.append(ll.get(i)).append(" "); //0번째 인덱스부터 9번째 인덱스를 스트링빌더에 담음.
			System.out.println("#" + tc + " " + sb); //테스트케이스번호와 스트링빌더 출력.
		}
		br.close();
	}
}
