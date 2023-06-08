import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.stream.Stream;


public class Main {
	static int[] dp;
	static int N;
	static StringBuilder sb;

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub				
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		sb=new StringBuilder();
	
		N=Integer.parseInt(br.readLine());
		dp=new int[N+1];
		for(int i=2;i<=N;i++) {
			dp[i]=dp[i-1]+1;
			if(i%2==0) {
				dp[i]=Math.min(dp[i], dp[i/2]+1);
			}
			if(i%3==0) {
				dp[i]=Math.min(dp[i], dp[i/3]+1);
			}
		}
		System.out.println(dp[N]);
	}
}