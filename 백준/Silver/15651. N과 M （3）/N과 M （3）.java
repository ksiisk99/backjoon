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
	static StringBuilder sb;
	
	public static void dfs(int depth) {
		if(depth==(M-1)) {
			StringBuilder tmp=new StringBuilder();
			for(int i=0;i<M-1;i++) {
				tmp.append(String.valueOf(arr[i])+" ");
			}
			for(int i=1;i<=N;i++) {
				sb.append(tmp.toString()+String.valueOf(i)+"\n");
			}
			return;
		}
		for(int i=1;i<=N;i++) {
			arr[depth]=i;
			dfs(depth+1);
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
		sb=new StringBuilder();
		
		dfs(0);
		System.out.println(sb.toString());
	}
}

