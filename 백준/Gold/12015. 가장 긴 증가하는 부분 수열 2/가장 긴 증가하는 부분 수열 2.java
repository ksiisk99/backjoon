import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb;
	static int[] arr;
	static int MAX=-1, MIN=1000000001;
	static int rst;
	static int M,N;
	static List<Integer> list;
	public static void binarySearch(int low, int high,int num) {
		if(low>high) {
			list.set(low, num);
			return;
		}
		int mid=(low+high)/2;
		
		if(list.get(mid)>=num) {
			binarySearch(low,mid-1,num);
		}else {
			binarySearch(mid+1,high,num);
		}								
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub				
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		sb=new StringBuilder();
				
		N=Integer.parseInt(br.readLine());
		list=new ArrayList<Integer>();
		list.add(0);
		arr=new int[N];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());  
			if(list.get(list.size()-1)<arr[i])list.add(arr[i]);
			else {
				binarySearch(0,list.size()-1, arr[i]);
			}
		}
		System.out.println(list.size()-1);
	}
}