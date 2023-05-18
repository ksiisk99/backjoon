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
		String str=br.readLine();
		int N=Integer.parseInt(br.readLine());
		int[][] dp=new int[26][200001];
			
		for(int i=0;i<str.length();i++) {
			dp[str.charAt(i)-97][i+1]=1;
		}
		
		for(int i=0;i<str.length()-1;i++) {
			for(int j=0;j<26;j++) {
				dp[j][i+2]+=dp[j][i+1];
			}
		}
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			int a=(int)st.nextToken().charAt(0)-97;
			int n1=Integer.parseInt(st.nextToken());
			int n2=Integer.parseInt(st.nextToken());
			//System.out.println(n2+" "+n1);
			int rst=dp[a][n2+1]-dp[a][n1];
			
			sb.append(String.valueOf(rst)+"\n");
		}
		System.out.print(sb.toString());		
	}
}