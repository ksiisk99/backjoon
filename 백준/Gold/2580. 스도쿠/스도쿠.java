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
	static int[][] arr;
	static int[] x;
	static int[] y;
	static int[] small;
	static int[] col;
	static int[] row;
	static boolean[] check;
	static int N;
	static StringBuilder sb;
	static boolean end=false;
	
	public static void back(int n) {
		if(end)return;
		if(n==N) {
			for(int i=0;i<9;i++) {
				for(int j=0;j<9;j++) {
					sb.append(String.valueOf(arr[i][j])+" ");
				}
				sb.append("\n");
				
			}
			end=true;
			return;
		}
		
		int X=x[n];
		int Y=y[n];
		for(int j=1;j<=9;j++) {
			if((col[Y]&(1<<j))==0 && (row[X]&(1<<j))==0 && (small[X/3*3+Y/3]&(1<<j))==0){
				col[Y]|=(1<<j);
				row[X]|=(1<<j);
				small[X/3*3+Y/3]|=(1<<j);
				check[n]=true;
				arr[X][Y]=j;
				//System.out.println(X+" "+Y);
				back(n+1);
				arr[X][Y]=0;
				col[Y]&=~(1<<j);
				row[X]&=~(1<<j);
				small[X/3*3+Y/3]&=~(1<<j);
				check[n]=false;
			}
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub				
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		sb=new StringBuilder();
		
		arr=new int[9][9];
		x=new int[81];
		y=new int[81];
		check=new boolean[81];
		small=new int[9];
		col=new int[9];
		row=new int[9];
		
		N=0;
		for(int i=0;i<9;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<9;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
				if(arr[i][j]==0) {
					x[N]=i;
					y[N++]=j;
					
				}else {
					row[i]|=(1<<arr[i][j]);
					col[j]|=(1<<arr[i][j]);
					int tmpX=i/3;
					int tmpY=j/3;
					small[tmpX*3+tmpY]|=(1<<arr[i][j]);
				}
			}
			
		}
		

		
		back(0);
	
		System.out.println(sb.toString());
		
		
	}
}