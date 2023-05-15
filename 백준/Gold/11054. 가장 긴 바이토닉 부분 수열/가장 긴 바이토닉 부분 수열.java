import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
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
	static StringBuilder sb;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub				
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		sb=new StringBuilder();
		int[] arr;
		int[] dp,dp2;
	
		st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		arr=new int[N+1];
		dp=new int[N+1];
		dp2=new int[N+1];
		
		st=new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		int MAX=-1;
		for(int i=1;i<=N;i++) {
			dp[i]=1;
			for(int j=1; j<=i; j++) {
				if(arr[i]>arr[j])
					dp[i]=Math.max(dp[i], dp[j]+1);
			}
		}
		
		for(int i=N;i>=1;i--) {
			dp2[i]=1;
			for(int j=i;j<=N;j++) {
				if(arr[i]>arr[j])
					dp2[i]=Math.max(dp2[i], dp2[j]+1);
			}
		}
		
		for(int i=1;i<=N;i++) {
			MAX=Math.max(MAX, dp[i]+dp2[i]);
		}
		
		System.out.println(MAX-1);
		
	}
}