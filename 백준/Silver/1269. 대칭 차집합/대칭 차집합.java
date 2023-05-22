import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb;
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub				
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		sb=new StringBuilder();
		
		Set<Integer> set=new HashSet<Integer>();
		Set<Integer> set2=new HashSet<Integer>();
		
		st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		int[] arr=new int[N];
		
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
			set.add(arr[i]);
		}
		
		int cnt=0;
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++) {
			int n=Integer.parseInt(st.nextToken());
			if(!set.contains(n)) {
				cnt++;
			}
			set2.add(n);
		}
		for(int i=0;i<N;i++) {
			if(!set2.contains(arr[i])) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}