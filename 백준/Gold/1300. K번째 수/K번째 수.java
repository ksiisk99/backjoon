import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb;
	static int[] arr;
	static int MAX=-1, MIN=1000000001;
	static int rst;
	static int M,N;
	public static int binarySearch(int low, int high) {
		if(low>high)return low;
		int mid=(low+high)/2;
		
		int cnt=0;
		for(int i=1;i<=N;i++) {
			cnt+=Math.min(mid/i, N);
		}
		
		if(cnt<M) {
			return binarySearch(mid+1,high);
		}else {
			return binarySearch(low,mid-1);
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub				
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		sb=new StringBuilder();
		
		//st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(br.readLine());
		M=Integer.parseInt(br.readLine());
		
	
		System.out.println(binarySearch(1,M));
	}
}