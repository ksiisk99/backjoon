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
	static StringBuilder sb=new StringBuilder();
	static void Hanoi(int A,int B,int C,int N) {
		if(N==1) {
			sb.append(String.valueOf(A)+" "+String.valueOf(C)+"\n");
			return;
		}
		Hanoi(A,C,B,N-1);
		sb.append(A+" "+C+"\n");
		Hanoi(B,A,C,N-1);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub				
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st;
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
				
		int N=Integer.parseInt(br.readLine());
		sb.append(String.valueOf((int)Math.pow(2, N)-1)+"\n");
		Hanoi(1,2,3,N);
		System.out.print(sb.toString());
	}
}