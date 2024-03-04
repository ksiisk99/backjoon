import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        while ((T--) > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            List<Integer>[] list = new ArrayList[n + 1];
            for (int i = 0; i < n; i++) {
                list[i] = new ArrayList<>();
            }

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                st.nextToken();

                while (st.hasMoreTokens()) {
                    list[i].add(Integer.parseInt(st.nextToken()));
                }
            }

            int[] 스티커 = new int[m + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= m; i++) {
                스티커[i] = Integer.parseInt(st.nextToken());
            }

            int 최대상금 = calculate(n, m, list, 스티커);
            answer.append(최대상금);
            answer.append("\n");
        }

        System.out.print(answer.toString());
    }

    private static int calculate(int n, int m, List<Integer>[] list, int[] 스티커) {
        int result = 0;

        for (int i = 0; i < n; i++) {
            int prize = list[i].get(list[i].size() - 1);

            if (checkStiker(list[i], 스티커)) {
                int stikerMinNumber = findStikerMinNumber(list[i], 스티커);
                result += prize * stikerMinNumber;
                removeStiker(list[i], 스티커, stikerMinNumber);
            }
        }

        return result;
    }

    private static int findStikerMinNumber(List<Integer> list, int[] 스티커) {
        int minNumber = Integer.MAX_VALUE;

        for (int j = 0; j < list.size() - 1; j++) {
            minNumber = Math.min(minNumber, 스티커[list.get(j)]);
        }

        return minNumber;
    }

    private static void removeStiker(List<Integer> list, int[] 스티커, int stikerMinNumber) {
        for (int j = 0; j < list.size() - 1; j++) {
            스티커[list.get(j)] -= stikerMinNumber;
        }
    }

    private static boolean checkStiker(List<Integer> list, int[] 스티커) {
        for (int j = 0; j < list.size() - 1; j++) {
            if (스티커[list.get(j)] == 0) {
                return false;
            }
        }

        return true;
    }

    private static void input() throws IOException {

    }

}

