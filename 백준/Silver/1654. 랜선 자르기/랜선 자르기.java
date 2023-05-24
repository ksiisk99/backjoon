import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb;
	static int[] arr;
	static long MAX=-1;
	static long rst;
	static int K,N;
	public static void binarySearch(long low, long high) {
		if(low>high) {
			return;
		}
		long mid=(low+high)/2;
		
		int cnt=0;
		
		for(int i=0;i<K;i++){
			cnt+=arr[i]/mid;
		}
		
		if(cnt>=N) {
			rst=Math.max(rst, mid);
			binarySearch(mid+1,high);
		}
		else {
			binarySearch(low,mid-1);
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub				
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		sb=new StringBuilder();
		
		st=new StringTokenizer(br.readLine());
		K=Integer.parseInt(st.nextToken());
		N=Integer.parseInt(st.nextToken());
		arr=new int[K];
		
		
		for(int i=0;i<K;i++) {
			arr[i]=Integer.parseInt(br.readLine());
			MAX=Math.max(MAX, arr[i]);
		}
		
		
		
		binarySearch(1,MAX);
		
		System.out.println(rst);
	}
}