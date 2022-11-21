import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb;
	static Integer[] arr;
	static long MAX=-1;
	static long rst;
	static int M,N;
	public static void binarySearch(long low, long high) {
		if(low>high)return;
		
		long mid=(low+high)/2;
		
		long cnt=0;
		for(int i=0;i<N;i++) {
			if(arr[i]>mid) {
				cnt+=(arr[i]-mid);
			}else {			
				break;
			}
			if(cnt>=M)break;
		}
		
		if(cnt>=M) {
			rst=Math.max(rst, mid);
			binarySearch(mid+1,high);
		}else {
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
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		arr=new Integer[N];
		
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
			MAX=Math.max(MAX, arr[i]);
		}
		
		Arrays.sort(arr, Collections.reverseOrder());
		
		binarySearch(1,MAX);
		
		System.out.println(rst);
	}
}