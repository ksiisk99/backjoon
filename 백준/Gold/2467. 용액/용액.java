import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static StringBuilder sb = new StringBuilder();
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        arr=new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        int left=0,right=N-1;
        int resultLeft=0;
        int resultRight=0;
        int resultSum=Integer.MAX_VALUE;

        while(left!=right){
            int sum=arr[left]+arr[right];
            if(resultSum>=Math.abs(sum)){
                resultSum=Math.abs(sum);
                resultLeft=left;
                resultRight=right;
            }

            if(sum>0){
                right--;
            }else if(sum==0){
                resultLeft=left;
                resultRight=right;
                break;
            }else{
                left++;
            }

        }

        sb.append(arr[resultLeft]);
        sb.append(" ");
        sb.append(arr[resultRight]);

        System.out.println(sb.toString());
    }

}