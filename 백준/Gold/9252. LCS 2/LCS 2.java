
import java.io.*;
import java.util.*;




public class Main {
	static int N;
	static StringBuilder sb;
	static int[][] dp;
	static int[] visit;

	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb=new StringBuilder();	
		
		
		String str=br.readLine();
		String str2=br.readLine();
		dp=new int[1001][1001];
		visit=new int[1001];
		
		for(int i=1;i<=str.length();i++) {
			for(int j=1;j<=str2.length();j++) {
				if(str.charAt(i-1)==str2.charAt(j-1)) {
					dp[i][j]=dp[i-1][j-1]+1;
					
				}else {
					dp[i][j]=Math.max(dp[i][j-1], dp[i-1][j]);
				}
			}
		}
		sb.append(dp[str.length()][str2.length()]+"\n");
		Stack<Character> stack=new Stack<>();
		int i=str.length();
		int j=str2.length();
		
		while(i>=1 && j>=1) {
			if(dp[i][j]==dp[i-1][j]) {
				i--;
			}else if(dp[i][j]==dp[i][j-1]) {
				j--;
			}else {
				stack.push(str.charAt(i-1));
				i--;j--;
			}
		}
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		System.out.println(sb.toString());
	}
}
