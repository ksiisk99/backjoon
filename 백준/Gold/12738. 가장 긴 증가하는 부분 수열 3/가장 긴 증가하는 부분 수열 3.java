import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N + 1];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> list = new ArrayList<>();
        list.add(arr[0]);
        for (int i = 1; i < N; i++) {
            if (list.get(list.size() - 1) < arr[i]) {
                list.add(arr[i]);
            } else {
                int left = 0;
                int right = list.size()-1;
                while (left < right) {
                    int mid = (left + right) / 2;
                    if (list.get(mid) < arr[i]) {
                        left = mid + 1;
                    } else {
                        right = mid ;
                    }
                }
                list.set(left, arr[i]);
            }
        }

        System.out.print(list.size());
    }
}