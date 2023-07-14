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
	static int MIN=1000000001;

	static int N;
	static int[][] arr;
	static boolean[] visited;
//	static StringBuilder sb;
	
	public static void back(int n, int cnt) {
		if(cnt==N/2) {
			int start=0;
			int link=0;
			
			for(int i=0;i<N-1;i++) {
				for(int j=i+1;j<N;j++) {
					if(visited[i] && visited[j]) {
						start+=arr[i][j]+arr[j][i];
					}else if(!visited[i] && !visited[j]){
						link+=arr[i][j]+arr[j][i];
					}
				}
			}
			MIN=Math.min(MIN, Math.abs(start-link));
			return;
		}
		
		for(int i=n;i<N;i++) {
			if(!visited[i]) {
				visited[i]=true;
				back(i+1,cnt+1);
				visited[i]=false;
			}
		}
	
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub				
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		//sb=new StringBuilder();
		N=Integer.parseInt(br.readLine());
		arr=new int[N][N];
		visited=new boolean[N];
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		back(0,0);
		System.out.println(MIN);
	}
}