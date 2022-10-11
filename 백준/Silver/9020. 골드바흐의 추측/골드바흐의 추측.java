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
		//StringTokenizer st=new StringTokenizer(br.readLine());
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb=new StringBuilder();
	
		boolean[] prime=new boolean[10001];
		int[] arr=new int[5000];
		prime[0]=prime[1]=true;
		int idx=0;
		
		for(int i=2;i<=10000;i++) {
			
			if(!prime[i]) {
				arr[idx++]=i;
				for(long j=i*2;j<=10000;j+=i) {
					prime[(int)j]=true;
				}
			}
		}
		int T=Integer.parseInt(br.readLine());
		for(int i=0;i<T;i++) {
			int N=Integer.parseInt(br.readLine());
			int n1=1,n2=1;
			int dif=10000;
			for(int j=0;j<idx;j++) {
				if(arr[j]>=N)break;
				for(int k=j;k<idx;k++) {
					if(arr[k]>=N)break;
					if(arr[j]+arr[k]==N && dif>arr[k]-arr[j]) {
						n1=arr[j];
						n2=arr[k];
						dif=arr[k]-arr[j];
					}
				}
			}
			sb.append(String.valueOf(n1)+" "+String.valueOf(n2)+"\n");
		}
		System.out.print(sb.toString());
	}	
}