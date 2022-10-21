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
		int[][] arr=new int[2][N]; //0:거리, 1:기름값
		
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<N-1;i++) {
			arr[0][i]=Integer.parseInt(st.nextToken());
		}
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[1][i]=Integer.parseInt(st.nextToken());
		}
		
		long dist=0;
		long price=0;
		int idx=0;
		
		for(int i=0;i<N-1;i++) {
			if(arr[1][idx]<=arr[1][i]) { //현재 노드의 기름 값이 쌀 경우
				dist+=arr[0][i];
			}else { //클 경우 현재까지 간 거리를 현재 노드의 기름 값을 더한다
				price+=arr[1][idx]*dist;
				dist=arr[0][i];
				idx=i;
			}
		}
		price+=dist*arr[1][idx];
		System.out.println(price);
	}
}