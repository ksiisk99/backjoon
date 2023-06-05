
import java.io.*;
import java.util.*;




public class Main {
	static int N;
	static StringBuilder sb;
	static int[] visit;
	static int[] arr;
	
	static void print(int n) {
		if(n==0)return;
		print(visit[n]);
		//System.out.println(n);
		sb.append(arr[n]+" ");
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb=new StringBuilder();	
		
		
		int N=Integer.parseInt(br.readLine());
		arr=new int[N+1];
		int[] dp=new int[N+1];
		visit=new int[N+1];
		
		st=new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		int MAX=1;
		int idx=1;
		for(int i=1;i<=N;i++) {
			dp[i]=1;
			for(int j=i;j>0;j--) {
				if(arr[i]>arr[j]) {
					if(dp[i]<dp[j]+1) {
						dp[i]=dp[j]+1;
						visit[i]=j;
					}
					if(MAX<dp[i]) {
						MAX=dp[i];
						idx=i;
					}
			
				}
			}
		}
		sb.append(MAX+"\n");
		print(idx);
		
		System.out.println(sb.toString());
		
	}
	

}
