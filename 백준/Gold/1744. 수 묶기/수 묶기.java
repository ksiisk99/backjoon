import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int left = 0;
        int right = N - 1;
        int answer = 0;

        for (; left < right; left += 2) {
            if (arr[left] < 1 && arr[left + 1] < 1) {
                answer += arr[left] * arr[left + 1];
            } else {
                break;
            }
        }

        for(; right>0; right-=2){
            if(arr[right]>1 && arr[right-1]>1){
                answer += arr[right] * arr[right-1];
            }else{
                break;
            }
        }

        for(;right>=left;right--){
            answer += arr[right];
        }

        System.out.print(answer);
    }

}
