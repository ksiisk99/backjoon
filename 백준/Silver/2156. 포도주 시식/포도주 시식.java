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
	static StringBuilder sb;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub				
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		sb=new StringBuilder();
		int[] arr;
		int[] dp;
		int N=Integer.parseInt(br.readLine());
		dp=new int[10001];
		arr=new int[10001];
		for(int i=1;i<=N;i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
		dp[1]=arr[1];
		dp[2]=arr[1]+arr[2];
		
		for(int i=3;i<=N;i++) {
			dp[i]=Math.max(dp[i-2], dp[i-3]+arr[i-1])+arr[i];
			dp[i]=Math.max(dp[i], dp[i-1]);
		}
	
		
		System.out.println(dp[N]);
	}
}