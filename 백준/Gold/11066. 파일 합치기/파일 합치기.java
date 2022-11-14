import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb;
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub				
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		sb=new StringBuilder();
		
		
		Map<String,Integer> map=new HashMap<>();
//		st=new StringTokenizer(br.readLine());
		int T=Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++) {
			int N=Integer.parseInt(br.readLine());
			st=new StringTokenizer(br.readLine());
			int[][] dp=new int[N+1][N+1];
			int[] sum=new int[N+1];
			
			for(int i=1;i<=N;i++) {
				sum[i]=sum[i-1]+Integer.parseInt(st.nextToken());
			}
			
			for(int i=1;i<N;i++) {
				for(int j=1;i+j<=N;j++) {
					dp[j][i+j]=Integer.MAX_VALUE;
					for(int k=j;k<i+j;k++) {
						dp[j][i+j]=Math.min(dp[j][i+j], dp[j][k]+dp[k+1][i+j]+sum[i+j]-sum[j-1]);
					}
					
				}
			}
			sb.append(dp[1][N]+"\n");
		}
		System.out.print(sb.toString());
	}
}