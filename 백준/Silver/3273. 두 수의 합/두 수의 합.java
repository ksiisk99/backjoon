

import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb=new StringBuilder();
	
	
		int N=Integer.parseInt(br.readLine());
		int[] arr=new int[N+1];

		st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i+1]=Integer.parseInt(st.nextToken());
		}
		int x=Integer.parseInt(br.readLine());
		
		int cnt=0;
		int start,end;
		start=1;
		end=N;
		int sum;
		Arrays.sort(arr);
		while(start<end) {
			sum=arr[start]+arr[end];
			
			if(sum==x) {
				cnt++;
				start++;
				end--;
			}else if(sum<x) {
				start++;
			}else {
				end--;
			}
		}
		System.out.println(cnt);
	}
	

}
