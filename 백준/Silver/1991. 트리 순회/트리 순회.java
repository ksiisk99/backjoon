import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb;
	static int N;
	static List<Node>[]tree;
	static class Node{
		char left;
		char right;
		public Node(char left, char right) {
			super();
			this.left = left;
			this.right = right;
		}
	}
	
	static void pre(int v) {
		sb.append((char)(v+65));
		if(tree[v].get(0).left!='.')
			pre(tree[v].get(0).left-65);
		if(tree[v].get(0).right!='.')
			pre(tree[v].get(0).right-65);
	}
	
	static void in(int v) {		
		if(tree[v].get(0).left!='.')
			in(tree[v].get(0).left-65);
		sb.append((char)(v+65));
		if(tree[v].get(0).right!='.')
			in(tree[v].get(0).right-65);
	}
	
	static void post(int v) {		
		if(tree[v].get(0).left!='.')
			post(tree[v].get(0).left-65);
		if(tree[v].get(0).right!='.')
			post(tree[v].get(0).right-65);
		sb.append((char)(v+65));
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb=new StringBuilder();
		
		N=Integer.parseInt(br.readLine());
		tree=new ArrayList[N+1];
		for(int i=0;i<=N;i++)tree[i]=new ArrayList<Node>();
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			char parent=st.nextToken().charAt(0);
			char left=st.nextToken().charAt(0);
			char right=st.nextToken().charAt(0);
			tree[parent-65].add(new Node(left,right));
		}
		pre(0);
		sb.append("\n");
		in(0);
		sb.append("\n");
		post(0);
		System.out.println(sb.toString());
		
	}
}
