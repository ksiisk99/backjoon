import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
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
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		boolean[] prime=new boolean[1000001];
		prime[0]=prime[1]=true;
		
		for(int i=2;i<=1000000;i++) {
			if(!prime[i]) {
				for(long j=i*2;j<=1000000;j+=i) {
					prime[(int)j]=true;
				}
			}
		}
		for(int i=N;i<=M;i++) {
			if(!prime[i]) {
				sb.append(i+"\n");
			}
		}
		System.out.print(sb.toString());
		
	}	
}