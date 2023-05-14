import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
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
		int T=Integer.parseInt(st.nextToken());
		for(int t=0;t<T;t++) {
			Deque<Integer> dq=new LinkedList<Integer>();
			st=new StringTokenizer(br.readLine());
			String str=st.nextToken();
			int N=Integer.parseInt(br.readLine());
			st=new StringTokenizer(br.readLine(),"[],");
			int[] arr=new int[N];
			int direct=1;
			int start=1;
			for(int i=0;i<N;i++) {
				arr[i]=Integer.parseInt(st.nextToken());
				dq.addLast(arr[i]);
			}
			
			for(int i=0;i<str.length();i++) {
				if(str.charAt(i)=='R') {
					direct*=-1;
				}else {
					if(dq.isEmpty()) {
						sb.append("error\n");
						break;
					}
					if(direct==-1) 
						dq.pollLast();
					else
						dq.pollFirst();
					
				}
				if(i==str.length()-1) {
					sb.append("[");
					while(!dq.isEmpty()) {
						if(direct==-1)
							sb.append(dq.pollLast());
						else
							sb.append(dq.pollFirst());
						if(!dq.isEmpty())
							sb.append(",");
					}
					sb.append("]\n");
				}
			}
		}
		
		System.out.print(sb.toString());
		
	}
}