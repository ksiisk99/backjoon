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
		int N=Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq=new PriorityQueue<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				if(Math.abs(o1)==Math.abs(o2)) {
					return o1-o2;
				}else if(Math.abs(o1)>Math.abs(o2)){
					return 1;
				}else return -1;
			
			}
		});
		
		for(int i=0;i<N;i++) {
			int n=Integer.parseInt(br.readLine());
			if(n==0) {
				if(pq.isEmpty()) {
					sb.append("0\n");
				}else {
					sb.append(pq.poll()+"\n");
				}
			}else {
				pq.add(n);
			}
		}
		pq.clear();
		System.out.println(sb.toString());
	}
}