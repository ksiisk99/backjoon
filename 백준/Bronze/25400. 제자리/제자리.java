import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder answer = new StringBuilder();
	private static int N;
	private static int[] arr;

	public static void main(String[] args) throws IOException {
		input();

		int number = 1;
		for (int i = 0; i < N; i++) {
			if(arr[i] == number) {
				number++;
			}
		}

		System.out.println(N - number + 1);
	}

	private static void input() throws IOException {
		N = Integer.parseInt(br.readLine());
		arr = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
	}
}
