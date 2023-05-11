import java.io.*;
import java.util.*;


public class Main {
	static StringBuilder sb;
	static int[] arr;
	
	public static void binarySearch(int low,int high,int num) {
		if(low>high) {
			sb.append("0\n");
			return;
		}
		int mid=(low+high)/2;
		if(arr[mid]<num)
			binarySearch(mid+1,high,num);
		else if(arr[mid]>num)
			binarySearch(low,mid-1,num);
		else
			sb.append("1\n");
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub				
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		sb=new StringBuilder();
		
		int N=Integer.parseInt(br.readLine());
		arr=new int[N];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int M=Integer.parseInt(br.readLine());
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++) {
			binarySearch(0,N-1,Integer.parseInt(st.nextToken()));
		}
		System.out.print(sb.toString());
	}
}