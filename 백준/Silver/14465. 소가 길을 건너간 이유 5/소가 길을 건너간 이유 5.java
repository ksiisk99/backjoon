import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		int[] arr = new int[N + 1];
		int[] sumArr = new int[N + 1];

		for (int i = 0; i < B; i++) {
			arr[Integer.parseInt(br.readLine())] = 1;
		}

		for (int i = 1; i <= N; i++) {
			sumArr[i] = sumArr[i - 1] + arr[i];
		}

		int answer = Integer.MAX_VALUE;
		for (int i = K; i <= N; i++) {
			answer = Math.min(answer, sumArr[i] - sumArr[i - K]);
		}

		System.out.println(answer);
	}

}


