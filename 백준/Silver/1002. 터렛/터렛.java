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
		StringTokenizer st;
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb=new StringBuilder();
		
		int T=Integer.parseInt(br.readLine());
		
		for(int i=0;i<T;i++) {
			st=new StringTokenizer(br.readLine());
			double x1=(double)Integer.parseInt(st.nextToken());
			double y1=(double)Integer.parseInt(st.nextToken());
			double r1=(double)Integer.parseInt(st.nextToken());
			double x2=(double)Integer.parseInt(st.nextToken());
			double y2=(double)Integer.parseInt(st.nextToken());
			double r2=(double)Integer.parseInt(st.nextToken());
			int distance=(int)(Math.abs(x1-x2)*Math.abs(x1-x2)+Math.abs(y1-y2)*Math.abs(y1-y2));
			
			if(x1==x2 && y1==y2 && r1==r2){
				sb.append("-1"+"\n");
			}else if(distance>Math.pow(r1+r2,2)) {
				sb.append("0"+"\n");
			}else if(distance<Math.pow(r2-r1, 2)) {
				sb.append("0"+"\n");
			}else if(distance==Math.pow(r2-r1, 2)) {
				sb.append("1"+"\n");
			}else if(distance==Math.pow(r1+r2, 2)) {
				sb.append("1"+"\n");
			}else {
				sb.append("2"+"\n");
			}
		}
		System.out.print(sb.toString());
	}
}