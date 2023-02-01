import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static StringBuilder sb;
    private static StringTokenizer st;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] heights = new int[N+2];
        for (int i = 1; i <= N; i++) {
            heights[i] = Integer.parseInt(br.readLine());
        }

        Stack<Integer>stack = new Stack<>();
        int ans=0;
        stack.push(0);
        for(int i=1;i<=N+1;i++){
            while(!stack.isEmpty() && heights[i]<heights[stack.peek()]){
                int idx=stack.pop();
                ans=Math.max(ans,(i-stack.peek()-1)*heights[idx]);
            }
            stack.push(i);
        }
        System.out.print(ans);
    }


}