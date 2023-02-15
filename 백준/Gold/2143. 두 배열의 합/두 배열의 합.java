import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N + 1];
        int[] continuousA = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            continuousA[i] = continuousA[i - 1] + A[i];
        }

        int M = Integer.parseInt(br.readLine());
        int[] B = new int[M + 1];
        int[] continuousB = new int[M + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
            continuousB[i] = continuousB[i - 1] + B[i];
        }

        Map<Integer, Integer> mapA = new HashMap<>();
        List<Integer> listA = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j <= N; j++) {
                int num = mapA.getOrDefault(continuousA[j] - continuousA[i], 0);
                mapA.put(continuousA[j] - continuousA[i], num + 1);
                if(num==0)listA.add(continuousA[j] - continuousA[i]);
            }
        }
        Collections.sort(listA);

        Map<Integer, Integer> mapB = new HashMap<>();
        List<Integer> listB = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            for (int j = i + 1; j <= M; j++) {
                int num = mapB.getOrDefault(continuousB[j] - continuousB[i], 0);
                mapB.put(continuousB[j] - continuousB[i], num + 1);
                if(num==0)listB.add(continuousB[j] - continuousB[i]);
            }
        }
        Collections.sort(listB);

        long result = 0;
        for (int i = 0; i < listA.size(); i++) {
            int numA = listA.get(i);
            int left = 0;
            int right = listB.size()-1;
            while (left <= right) {
                int mid = (left + right) / 2;
                int numB = listB.get(mid);
                int sum = numA + numB;
                if (sum > T) {
                    right = mid - 1;
                } else if (sum == T) {
                    result += (long) mapA.get(numA) * mapB.get(numB);
                    break;
                } else {
                    left = mid + 1;
                }
            }
        }
        System.out.println(result);
    }
}