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
	static void divide(int x,int y,int n) {
		if(x/n%3==1 && y/n%3==1) {
			sb.append(" ");
		}else if(n/3==0) {
			sb.append("*");
		}else {
			divide(x,y,n/3);
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub				
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st;
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
				
		int N=Integer.parseInt(br.readLine());
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				divide(i,j,N);
			}
			sb.append("\n");
		}
		System.out.print(sb.toString());
	}
}