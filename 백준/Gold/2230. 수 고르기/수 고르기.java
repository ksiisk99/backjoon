import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static int N, M;
	private static int[] arr;

	public static void main(String[] args) throws IOException, InterruptedException {
		input();

		Arrays.sort(arr);

		int answer = Integer.MAX_VALUE;

		int left = 0;
		int right = 0;

		while (left <= right) {
			int diff = Math.abs(arr[right] - arr[left]);

			if (diff >= M) {
				left++;
				answer = Math.min(answer, diff);
			} else {
				if (right == (N - 1)) {
					left++;
				} else {
					right++;
				}
			}
		}

		System.out.println(answer);
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
	}

}
