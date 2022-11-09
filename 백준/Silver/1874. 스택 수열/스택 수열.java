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
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub				
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		sb=new StringBuilder();
	
		
		Stack<Integer> stack=new Stack<Integer>();
		int N=Integer.parseInt(br.readLine());
		int[] arr=new int[N+1];
		int idx=1;
		for(int i=1;i<=N;i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
		int k=1;
		
		for(int i=1;i<=N;i++) {
			if(k>arr[i]) {
				int tmp=stack.pop();
				if(tmp==arr[i]) {
					sb.append("-\n");
				}else {
					break;
				}
			}
			while(k<arr[i]) {
				stack.push(k++);
				sb.append("+\n");
				//System.out.println("k<arr[i]"+k);
			}
			if(k==arr[i]) {
				sb.append("+\n");
				sb.append("-\n");
				k++;
				//System.out.println("k==arr[i]"+k);
			}
		}
		//System.out.print(sb.toString());
		if(stack.isEmpty())
			System.out.print(sb.toString());
		else
			System.out.println("NO");
	}
}