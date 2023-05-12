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
	static boolean[] col;
	static boolean[] right;
	static boolean[] left;
	static int N;
	static int cnt=0;
	
	public static void back(int n) {
		if(n==N) {
			cnt++;
			return;
		}
		for(int i=0;i<N;i++) {
			if(!col[i] && !right[i+N-n] && !left[i+n]) {		
				right[i+N-n]=true;
				left[i+n]=true;
				col[i]=true;
				back(n+1);
				right[i+N-n]=false;
				col[i]=false;
				left[i+n]=false;
			}
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub				
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb=new StringBuilder();
		
		N=Integer.parseInt(st.nextToken());
		
		col=new boolean[N];
		right=new boolean[N*2];
		left=new boolean[N*2];
		
		
		back(0);
		
		System.out.println(cnt);
	}
}