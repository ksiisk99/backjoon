import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
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
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub				
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb=new StringBuilder();
		int N;
		
		N=Integer.parseInt(st.nextToken());
		int cnt=0;
		int num=665;
		while(N>cnt) {
			num++;
			String tmp=String.valueOf(num);
			
			boolean check=false;
			int a=0;
			for(int i=0;i<tmp.length();i++) {
				if(tmp.charAt(i)=='6' && !check) {
					check=true;
					a++;
				}else if(tmp.charAt(i)=='6' && check) {
					a++;
				}else if(tmp.charAt(i)!='6' && check) {
					check=false;
					a=0;
				}
				if(a==3) {
					cnt++;
			
					break;
				}
			}
			if(cnt==N) {
				System.out.println(num);
			}
		}
		
	}
}