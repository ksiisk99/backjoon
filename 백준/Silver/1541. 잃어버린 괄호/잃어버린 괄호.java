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
		StringTokenizer st,st2;
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		sb=new StringBuilder();
	
		st=new StringTokenizer(br.readLine(),"-");
		int rst=1000000;
		while(st.hasMoreTokens()) {
			st2=new StringTokenizer(st.nextToken(),"\\+");
			int tmp=0;
			while(st2.hasMoreTokens()) {
				tmp+=Integer.parseInt(st2.nextToken());
			}
			if(rst==1000000)rst=tmp;
			else rst-=tmp;
		}
		System.out.println(rst);
	}
}