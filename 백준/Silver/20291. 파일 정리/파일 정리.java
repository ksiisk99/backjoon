import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N;
    private static StringBuilder sb = new StringBuilder();
    private static Map<String, Integer> map = new HashMap<>();

    static class Info implements Comparable<Info> {
        String s;
        int cnt;

        @Override
        public int compareTo(Info o) {
            return s.compareTo(o.s);
        }

        public Info(String s, int cnt) {
            this.s = s;
            this.cnt = cnt;
        }

        @Override
        public String toString() {
            return s+" "+cnt;
        }
    }


    public static void main(String[] args) throws IOException {
        input();

        List<Info> answer = new ArrayList<>();
        for(String key: map.keySet()) {
            answer.add(new Info(key, map.get(key)));
        }

        Collections.sort(answer);

        answer.stream()
                .map(info -> info.toString())
                .forEach(s -> sb.append(s+"\n"));

        System.out.print(sb.toString());
    }

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());


        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            String[] arr = s.split("\\.");

            Integer cnt = map.getOrDefault(arr[1], 0) + 1;
            map.put(arr[1], cnt);
        }


    }
}
