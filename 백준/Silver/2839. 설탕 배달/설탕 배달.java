import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.stream.Stream;


public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub				
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb=new StringBuilder();
		int N=Integer.parseInt(st.nextToken());
		int[] dp=new int[5001];
		Arrays.fill(dp, 99999);
		
		
		if(N<5 && N!=3)
			System.out.println(-1);
		else {	
			dp[3]=1;
			dp[5]=1;
			for(int i=5;i<=N;i++) {
				dp[i]=Math.min(dp[i], dp[i-3]+1);
				dp[i]=Math.min(dp[i], dp[i-5]+1);
			}
			System.out.println(dp[N]==99999?-1:dp[N]);
		}
		
	}
}