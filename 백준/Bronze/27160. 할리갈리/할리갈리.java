import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static int N;
    private static List<Fruit> fruits = new ArrayList<>();
    private static Map<String, Integer> map = new HashMap<>() {{
        put("STRAWBERRY", 0);
        put("BANANA", 0);
        put("LIME", 0);
        put("PLUM", 0);
    }};

    static class Fruit {
        String name;
        Integer count;

        public Fruit(String name, Integer count) {
            this.name = name;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
        input();

        for (Fruit fruit : fruits) {
            Integer beforeCount = map.get(fruit.name);
            Integer totalCount = beforeCount + fruit.count;
            map.put(fruit.name, totalCount);
        }


        String answer = "NO";
        for (Integer count : map.values()) {
            if(count==5) {
                answer = "YES";
                break;
            }
        }
        System.out.print(answer);
    }

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String s = br.readLine();

            String[] info = s.split(" ");
            String name = info[0];
            Integer count = Integer.valueOf(info[1]);

            fruits.add(new Fruit(name, count));
        }
    }
}