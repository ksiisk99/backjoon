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
        List<Integer> list = calcPrime(N);

        int left = 0, right = 0;

        int answer = 0;
        int sum = 0;
        final int SIZE = list.size();
        while (left<SIZE) {
            if (sum < N && right < SIZE) {
                sum += list.get(right++);
            } else  {
                if(sum == N) answer++;
                sum -= list.get(left++);
            }
        }
        System.out.println(answer);
    }

    private static List<Integer> calcPrime(int N) {
        List<Integer> list = new ArrayList<>();

        boolean[] check = new boolean[N + 1];
        for (int i = 2; i <= Math.sqrt(N); i++) {
            if (check[i]) {
                continue;
            }
            for (int j = i + i; j <= N; j += i) {
                check[j] = true;
            }
        }

        for(int i=2;i<=N;i++){
            if(!check[i]) {
                list.add(i);
            }
        }
        return list;
    }
}