import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static double total;
    private static StringBuilder sb = new StringBuilder();
    private static Map<String, Integer> tree = new HashMap<>();
    private static List<String> in = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        input();

        Collections.sort(in);

        for (String s : in) {
            String average = calculateAverage(s);
            sb.append(s + " " + average + "\n");
        }

        System.out.print(sb.toString());
    }

    private static String calculateAverage(String s) {
        double average = (tree.get(s) * 100) / total;
        return String.format("%.4f", average);
    }

    private static void input() throws IOException {
        String s;
        while ((s = br.readLine()) != null) {
            if (!tree.containsKey(s)) {
                in.add(s);
            }
            tree.put(s, tree.getOrDefault(s, 0) + 1);
            total++;
        }

    }
}
