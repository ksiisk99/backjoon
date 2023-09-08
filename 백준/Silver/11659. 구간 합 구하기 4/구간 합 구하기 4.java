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
		st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		st=new StringTokenizer(br.readLine());
		int[] arr=new int[N+1];
		for(int i=1;i<=N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
			arr[i]+=arr[i-1];
		}
		
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			int rst=arr[b]-arr[a-1];
			sb.append(String.valueOf(rst)+"\n");
		}
		System.out.print(sb.toString());
		
	}
}