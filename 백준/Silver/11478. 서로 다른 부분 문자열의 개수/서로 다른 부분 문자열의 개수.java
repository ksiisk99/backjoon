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
		
		
		Map<String,Integer> map=new HashMap<>();
//		st=new StringTokenizer(br.readLine());
//		int N=Integer.parseInt(st.nextToken());
//		int M=Integer.parseInt(st.nextToken());
//		int[] arr=new int[N];
		
		String str=br.readLine();
		int cnt=0;
		
		for(int i=0;i<str.length();i++) { //횟수
			for(int j=0;j+i<str.length();j++) {
				if(!map.containsKey(str.substring(j, j+i+1))){
					cnt++;
					map.put(str.substring(j, j+i+1), 1);
				}
			}
		}
		
		System.out.println(cnt);
	}
}