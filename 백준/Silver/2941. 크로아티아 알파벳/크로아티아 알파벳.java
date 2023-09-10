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
		StringTokenizer st=new StringTokenizer(br.readLine());
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb=new StringBuilder();
		String[] croatia={"c=","c-","dz=","d-","lj","nj","s=","z="};
		String str=st.nextToken();
		int cnt=str.length();
		int n=0;
		for(int i=0;i<str.length()-1;i++) {
			for(int j=0;j<8;j++) {
				n=i;
				String tmp=String.valueOf(str.charAt(n))+String.valueOf(str.charAt(n+1));
				boolean check=false;
				
				if(croatia[j].equals(tmp)) {
					cnt--;
					n+=1;
					break;			
				}
				if(n+2<str.length()) {
					tmp+=String.valueOf(str.charAt(n+2));
					if(croatia[j].equals(tmp)){
						cnt-=2;
						n+=2;
						break;
					}
				}
				if(check)break;
			}
			i=n;
		}
		System.out.println(cnt);
	}
}