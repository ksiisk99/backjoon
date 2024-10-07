import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	private static int N, K;
	private static Point[] points;

	static class Point {
		int a, b;

		public Point(int a, int b) {
			this.a = a;
			this.b = b;
		}
	}

	public static void main(String[] args) throws IOException, InterruptedException {
		input();

		int[] arr = new int[1000001];
		for (Point point : points) {
			arr[point.a]++;
			arr[point.b]--;
		}

		for (int i = 1; i < 1000001; i++) {
			arr[i] += arr[i - 1];
		}

		long sum = 0L;
		int left = 0, right = 0;
		while (true) {
			if (sum < K) {
				sum += arr[right++];
			} else if (sum > K) {
				sum -= arr[left++];
			} else {
				System.out.println(left + " " + right);
				break;
			}

			if (right == 1000001) {
				left = right + 1;
				break;
			}
		}

		if (left > right) {
			System.out.println("0 0");
		}
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		points = new Point[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			points[i] = new Point(a, b);
		}
	}
}
