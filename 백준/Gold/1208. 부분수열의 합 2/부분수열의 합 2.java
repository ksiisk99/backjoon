import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    private static StringBuilder sb;
    private static StringTokenizer st;
    private static int[] arr;
    private static Map<Integer,Integer>map;
    private static long result=0;

    private static void leftSum(int start, int sum, int size){
        if(start==size){
            map.put(sum,map.getOrDefault(sum,0)+1);
            return;
        }
        leftSum(start+1,sum,size);
        leftSum(start+1,sum+arr[start],size);
    }

    private static void rightSum(int start, int sum, int size,int S){
        if(start==size){
            result+=map.getOrDefault(S-sum,0);
            return;
        }
        rightSum(start+1,sum,size,S);
        rightSum(start+1,sum+arr[start],size,S);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        arr=new int[N];
        map=new HashMap<>();
        st=new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        leftSum(0,0,N/2);
        rightSum(N/2,0,N,S);


        if(S==0) System.out.println(result-1);
        else System.out.println(result);
    }

}