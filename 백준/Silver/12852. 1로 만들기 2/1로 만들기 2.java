
import java.io.*;
import java.util.*;


public class Main {
	static int N;
	static int[] arr;
	static int[] visit;
	static StringBuilder sb;
	static int cnt;
	
	static void print(int n) {
		if(n==0)return;
		print(visit[n]);
		sb.append(n+" ");
		cnt++;
	}
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb=new StringBuilder();	
		st=new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		arr=new int[1000001];
		visit=new int[1000001];
		Arrays.fill(arr, Integer.MAX_VALUE);
		arr[N]=0;
		Queue<Integer>queue=new LinkedList<Integer>();
		queue.add(N);
		while(!queue.isEmpty()) {
			int cur=queue.poll();
			int next=cur-1;
			if(next>0 && arr[next]>arr[cur]+1) {
				visit[next]=cur;
				arr[next]=arr[cur]+1;
				queue.add(next);
			}
			
			next=cur/3;
			if(cur%3==0 && arr[next]>arr[cur]+1) {
				visit[next]=cur;
				arr[next]=arr[cur]+1;
				queue.add(next);
			}
			
			next=cur/2;
			if(cur%2==0 && arr[next]>arr[cur]+1) {
				visit[next]=cur;
				arr[next]=arr[cur]+1;
				queue.add(next);
			}
		}
		print(1);
		System.out.println(cnt-1);
		System.out.println(sb.toString());
	}
	

}
