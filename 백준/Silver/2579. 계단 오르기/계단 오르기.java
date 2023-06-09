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
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub				
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb=new StringBuilder();
	
		int N=Integer.parseInt(br.readLine());
		
		int[] arr=new int[301];
		int[] dp=new int[301];
		
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
		dp[0]=arr[0];
		dp[1]=arr[0]+arr[1];
		dp[2]=Math.max(dp[0]+arr[2], arr[1]+arr[2]);
		
		for(int i=3;i<N;i++) {
			dp[i]=Math.max(dp[i-2], dp[i-3]+arr[i-1])+arr[i];
		}
		System.out.println(dp[N-1]);
	}
}