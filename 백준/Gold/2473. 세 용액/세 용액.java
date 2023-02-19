import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static StringBuilder sb = new StringBuilder();
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        arr=new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int resultLeft=0,resultRight=0,resultMid=0;
        long resultSum = Long.MAX_VALUE;
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        for(int i=0;i<N-2;i++){
            int left=i+1, right=N-1;
            while(left<right){
                long sum = (long)arr[i]+arr[left]+arr[right];
                if(Math.abs(sum)<resultSum){
                    resultSum=Math.abs(sum);
                    resultMid=arr[i];
                    resultLeft=arr[left];
                    resultRight=arr[right];
                }

                if(sum<0)left++;
                else right--;
            }
        }
        sb.append(resultMid+" ");
        sb.append(resultLeft+" ");
        sb.append(resultRight);

        System.out.print(sb.toString());
    }

}