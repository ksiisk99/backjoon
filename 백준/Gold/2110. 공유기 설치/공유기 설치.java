import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb;
	static int[] arr;
	static int MAX=-1, MIN=1000000001;
	static int rst;
	static int M,N;
	public static void binarySearch(int low, int high) {
		if(low>high)return;
		
		int mid=(low+high)/2;
		
		int cnt=1;
		
		for(int i=0;i<N-1;) {
			int j=i+1;
			for(;j<N;j++) {
			
				if(Math.abs(arr[i]-arr[j])>=mid) { //매개변수의 길이랑 같거나 클 경우
					cnt++;
					i=j;
					break;
				}
				if(j==(N-1)) {
					i++;
					break;
				}
			}
			if(cnt==M)break;
			if((N-i)<=(M-cnt)) {
				break;		
			}
		}
		
		if(cnt==M) {
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
		arr=new int[N];
		
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(br.readLine());
			MAX=Math.max(MAX, arr[i]);
			MIN=Math.min(MIN, arr[i]);
		}
		
		Arrays.sort(arr);
		binarySearch(1,MAX-MIN);
		System.out.println(rst);
	}
}