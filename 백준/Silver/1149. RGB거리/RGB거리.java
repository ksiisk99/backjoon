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
		int[][] arr=new int[N+1][3];
		int[][] rgb=new int[N+1][3];
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<3;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		rgb[0][0]=arr[0][0];
		rgb[0][1]=arr[0][1];
		rgb[0][2]=arr[0][2];
		
		for(int i=1;i<N;i++) {
			for(int j=0;j<3;j++) {
				if(j==0) {
					rgb[i][j]=Math.min(rgb[i-1][j+1], rgb[i-1][j+2]);
				}else if(j==1) {
					rgb[i][j]=Math.min(rgb[i-1][j-1], rgb[i-1][j+1]);
				}else {
					rgb[i][j]=Math.min(rgb[i-1][j-1], rgb[i-1][j-2]);
				}
				rgb[i][j]+=arr[i][j];
			}
		}
		int MIN=rgb[N-1][0];
		for(int i=1;i<3;i++) {
			MIN=Math.min(MIN, rgb[N-1][i]);
		}
		System.out.println(MIN);
	}
}