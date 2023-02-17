import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static StringBuilder sb = new StringBuilder();
    private static int[] arr = new int[100001];
    private static int[][][] dp = new int[100001][5][5]; //현재 가려는 발판에서 왼발 오른발
    private static int N;

    private static int move(int cnt, int left, int right) {
        if (cnt == N) {
            return 0;
        }

        if (dp[cnt][left][right] != 0){
            return dp[cnt][left][right];
        }

        return dp[cnt][left][right] = Math.min(move(cnt+1,arr[cnt],right)+calcPower(left,arr[cnt]),
                move(cnt+1,left,arr[cnt])+calcPower(right,arr[cnt]));
    }

    private static int calcPower(int from, int to) {
        if (from == to) {
            return 1;
        }
        switch (from) {
            case 0:
                return 2;
            case 1:
                return to == 3 ? 4 : 3;
            case 2:
                return to == 4 ? 4 : 3;
            case 3:
                return to == 1 ? 4 : 3;
            default:
                return to == 2 ? 4 : 3;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        while (st.hasMoreElements()) {
            int num = Integer.parseInt(st.nextToken());
            if (num != 0) {
                arr[N++] = num;
            }
            //N++;
        }

        System.out.println(move(0,0,0));
    }

}