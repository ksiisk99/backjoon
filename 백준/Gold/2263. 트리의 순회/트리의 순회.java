import java.io.*;
import java.util.*;


public class Main {
	static StringBuilder sb;
	static int N;
	static int[] in;
	static int[] post;
	static int[] position;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb=new StringBuilder();
		
		N=Integer.parseInt(br.readLine());
		in=new int[N];
		post=new int[N];
		position=new int[N+1];
		
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			in[i]=Integer.parseInt(st.nextToken());
			position[in[i]]=i;
		}
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			post[i]=Integer.parseInt(st.nextToken());
		}
		recursive(0,N-1,0,N-1);
		System.out.println(sb.toString());
	}
	
	static void recursive(int is, int ie,int ps,int pe) {
		if(is>ie || ps>pe)return;
		if(is>ie || ps>ie)return;
		int root=post[pe];
		sb.append(root+" ");
		int left=position[root]-is;
		recursive(is,position[root]-1,ps,ps+left-1);
		recursive(position[root]+1,ie,ps+left,pe-1);
	}
}
