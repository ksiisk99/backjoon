import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());

		int[] down = new int[N / 2];
		int[] up = new int[N / 2];

		for (int i = 0; i < N / 2; i++) {
			down[i] = Integer.parseInt(br.readLine());
			up[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(down);
		Arrays.sort(up);

		int min = N;
		int cnt = 0;

		for (int i = 1; i <= H; i++) {
			int t = lowerBound(0, N / 2, i, down) + lowerBound(0, N / 2, H - i + 1, up);

			if (t == min) {
				cnt++;
			} else if (t < min) {
				cnt = 1;
				min = t;
			}
		}

		System.out.println(min + " " + cnt);
	}

	static int lowerBound(int left, int right, int h, int[] arr) {
		while (left < right) {
			int mid = (left + right) / 2;

			if (arr[mid] < h) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}

		return arr.length - left;
	}
}
