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
		StringTokenizer st=new StringTokenizer(br.readLine());
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb=new StringBuilder();
		int N;
		int M;
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		char[][] board=new char[N][M];
		
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			String tmp=st.nextToken();
			for(int j=0;j<M;j++) {
				board[i][j]=tmp.charAt(j);
			}
		}
		
		int MIN=2501;
		for(int i=0;i<N;i++) {
			if(i+8>N)break;
			for(int j=0;j<M;j++) {
				if(j+8>M)break;
				if(i+8<=N) { //8x8로 분할이 가능하다면
					char tmp=board[i][j]; //기준 문자;
					char tmp2=tmp=='B'?'W':'B'; //기준 문자와 다른 문자
					int point=j%2;
					int cnt=0;
					
					for(int x=i;x<i+8;x++) {
						for(int y=j;y<j+8;y++) {
							
							if(y%2==point) {
								if(board[x][y]!=tmp) {
									//System.out.println(x+" "+y);
									cnt++;
								}
							}else {
								if(board[x][y]!=tmp2) {
									//System.out.println(x+" "+y);
									cnt++;
								}
							}
						}
						tmp=tmp=='B'?'W':'B';
						tmp2=tmp2=='B'?'W':'B';
					}
					cnt=Math.min(cnt, 64-cnt);
					MIN=Math.min(MIN, cnt);
				}
			}
		}
		System.out.println(MIN==2501?0:MIN);
	}
}