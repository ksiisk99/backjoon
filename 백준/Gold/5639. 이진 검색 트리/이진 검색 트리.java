
import java.io.*;
import java.util.*;


public class Main {
	static StringBuilder sb;
	static int N;
	static int[] pre;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb=new StringBuilder();
		
		N=0;
		pre=new int[10001];
		String input="";
		while((input=br.readLine())!=null) {
			pre[N++]=Integer.parseInt(input);
		}
		
		recursive(0,N-1);
		System.out.println(sb.toString());
	}
	
	static void recursive(int s,int e) {
		if(s>e)return;
		int num=pre[s];
		int size=0;
		for(int i=s+1;i<=e;i++) {
			if(num>pre[i]) {
				size++;
			}else break;
		}
		recursive(s+1,s+size);
		recursive(s+size+1,e);
		sb.append(num+"\n");
	}
}
