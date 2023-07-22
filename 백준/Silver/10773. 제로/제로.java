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
	
	static class Room implements Comparable<Room>{
		int start;
		int end;
		public Room(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}
		@Override
		public int compareTo(Room o) {
			// TODO Auto-generated method stub
			if(this.end==o.end) {
				return this.start-o.start;
			}else
				return this.end-o.end;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub				
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		sb=new StringBuilder();
	
		st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		Stack<Integer> stack=new Stack<Integer>();
		
		for(int i=0;i<N;i++) {
			int num=Integer.parseInt(br.readLine());
			if(num==0)stack.pop();
			else stack.push(num);
		}
		int rst=0;
		while(!stack.isEmpty()) {
			rst+=stack.pop();
		}
		System.out.println(rst);
	}
}