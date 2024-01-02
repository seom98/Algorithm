import java.util.*;
public class Main {
	public static void main(String[] e){
		Scanner s=new Scanner(System.in);
		int N=s.nextInt();
		int M=s.nextInt();
		int L=N-M;
		int[]f={5,25,125,625,3125,15625,78125,390625,1953125,9765625,48828125,244140625,1220703125};
		int[]t={2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,131072,262144,524288,1048576,2097152,4194304,8388608,16777216,33554432,67108864,134217728,268435456,536870912,1073741824};
		int a=0,b=0,c=0,d=0;
		for(int i=0;i<13;i++){
			if(f[i]<=N)a+=N/f[i];
			if(f[i]<=M)b+=M/f[i];
			if(f[i]<=L)b+=L/f[i];
		}
		for(int i=0;i<30;i++){
			if(t[i]<=N)c+=N/t[i];
			if(t[i]<=M)d+=M/t[i];
			if(t[i]<=L)d+=L/t[i];
		}
		System.out.print(a-b<c-d?a-b:c-d);
	}
}