import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {
	
	static int N,M;
	static int[] arr;
	static boolean[] visited;
	
	
	public static void dfs(int start,int cnt) {
		if(cnt==M) {
			StringBuilder sb=new StringBuilder();
			for(int i=0;i<M;i++) {
				sb.append(String.valueOf(arr[i])+" ");
			}
			System.out.println(sb.toString());
		}
		
		for(int i=start;i<=N;i++) {
			if(!visited[i]) {
				visited[i]=true;
				arr[cnt]=i;
				dfs(i+1,cnt+1);
				visited[i]=false;
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub				
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		visited=new boolean[N+1];
		arr=new int[N+1];
		
		dfs(1,0);
	}
}

