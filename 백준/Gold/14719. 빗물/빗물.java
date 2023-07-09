import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int[] arr = new int[W + 1];
        int maxH = 0, maxL = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < W; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (maxH < arr[i]) {
                maxH = arr[i];
                maxL = i;
            }
        }

        int tmpMaxH = 0;
        int result = 0;
        for (int i = 0; i <= maxL; i++) {
            if (tmpMaxH < arr[i]) {
                tmpMaxH = arr[i];
            } else {
                result += (tmpMaxH - arr[i]);
            }
        }

        tmpMaxH = 0;
        for (int i = W - 1; i >= maxL; i--) {
            if (tmpMaxH < arr[i]) {
                tmpMaxH = arr[i];
            } else {
                result += (tmpMaxH - arr[i]);
            }
        }

        System.out.print(result);
    }
    
}
