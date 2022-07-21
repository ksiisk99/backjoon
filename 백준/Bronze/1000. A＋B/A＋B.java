
import java.io.*;
import java.util.*;


public class Main {
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb=new StringBuilder();
		st=new StringTokenizer(br.readLine());
		System.out.println(Integer.parseInt(st.nextToken())+Integer.parseInt(st.nextToken()));
	}
}
