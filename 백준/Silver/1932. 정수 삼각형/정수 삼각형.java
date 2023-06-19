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
		int[][] arr=new int[N+1][N+1];
		int[][] tri=new int[N+1][N+1];
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			int idx=0;
			while(st.hasMoreTokens()) {
				arr[i][idx++]=Integer.parseInt(st.nextToken());
			}
		}
		tri[0][0]=arr[0][0];
		
		for(int i=1;i<N;i++) {
			for(int j=0;j<=i;j++) {
				if(j==0) {
					tri[i][j]=tri[i-1][j];
				}else if(j==N-1) {
					tri[i][j]=tri[i-1][j-1];
				}else {
					tri[i][j]=Math.max(tri[i-1][j-1], tri[i-1][j]);
				}
				tri[i][j]+=arr[i][j];
			}
		}
		int MAX=-1;
		for(int i=0;i<N;i++) {
			MAX=Math.max(MAX, tri[N-1][i]);
		}
		System.out.println(MAX);
		
	}
}