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
		int N=Integer.parseInt(st.nextToken());
		int cnt=N;
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			String str=st.nextToken();
			boolean[] check=new boolean[32];
			for(int j=0;j<str.length();j++) {
				if(check[(int)str.charAt(j)-97]) {
					cnt--;
					break;
				}else {
					char tmp=str.charAt(j);
					check[(int)tmp-97]=true;
					for(int k=j+1;k<str.length();k++) {
						if(tmp==str.charAt(k)) {
							j++;
						}else {
							break;
						}
					}
				}
			}
		}
		System.out.println(cnt);
	}
}