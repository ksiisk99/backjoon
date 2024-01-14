import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static int N, D, maxHeight;
    private static Map<Integer, Integer> buildings = new HashMap<>();


    public static void main(String[] args) throws IOException {
        input();

        long answer = 0;
        for (int d = 0; d < D && maxHeight > 0; d++) {
            while (maxHeight > 0) {
                if (buildings.containsKey(maxHeight)) {
                    break;
                }
                maxHeight--;
            }

            int buildingCount = buildings.getOrDefault(maxHeight, 0);
            buildings.remove(maxHeight);
            answer += buildingCount;
            maxHeight--;

            if(maxHeight <= 0) break;

            int beforeBuildingCount = buildings.getOrDefault(maxHeight, 0);
            buildings.put(maxHeight, beforeBuildingCount + buildingCount);
        }

        System.out.print(answer);
    }

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int height = Integer.parseInt(st.nextToken());
            int cnt = buildings.getOrDefault(height, 0);
            buildings.put(height, cnt + 1);
            maxHeight = Math.max(maxHeight, height);
        }
    }

}