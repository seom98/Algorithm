import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(br.readLine());
	
	//첫번째로 받는 숫자가 N임.
	int N = Integer.parseInt(st.nextToken()); 

	for (int i = 1; i <= N; i++) { //N번 포문도는거임.
	    //한줄을 받고 바로 " "를 기준으로 전부 나눠서 잘라서 배열에 넣음.
	    String[] arr = br.readLine().split(" ");
	    
	    for (int j = 0; j < arr.length; j++) { //나눠진 단어들의 개수만큼 포문돎.
		//한 단어씩 ""기준으로 전부 나눠서 배열에 넣음. arr 자식이라 arrson임.
		String[] arrson = arr[j].split("");
		//뒤집힌 단어를 넣을 새로운 배열 만듦. arrson 뒤집혀서 nosrra임.
		String[] nosrra = new String[arrson.length];
		for (int k = 0; k < arrson.length; k++) { //arrson개수만큼 포문돎.
		    //순서 바꿔줌.
		    nosrra[k] = arrson[arrson.length - k - 1];
		}
		//단어 다 뒤집혀졌으니까 arr에 집어 넣음.
		arr[j] = String.join("", nosrra);
	    }
	    //이제 이친구들을 하나씩 출력함.
	    System.out.println(String.join(" ", arr));
	}
    }

}