import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int K, L;
    private static Map<String,Integer> map = new HashMap<>();
    private static Queue<String> queue = new LinkedList<>();

    static class Info implements Comparable<Info>{
        Integer idx;
        String studentId;

        public Info(Integer idx, String studentId) {
            this.idx = idx;
            this.studentId = studentId;
        }

        @Override
        public int compareTo(Info o) {
            return idx - o.idx;
        }
    }


    public static void main(String[] args) throws IOException {
        input();
        StringBuilder sb = new StringBuilder();

        List<Info> list = new ArrayList<>();
        for(String studentId: map.keySet()) {
            Integer value = map.get(studentId);
            list.add(new Info(value, studentId));
        }

        Collections.sort(list);
        for(int i=0;i<K && i<list.size();i++){
            
            sb.append(list.get(i).studentId);
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }

    public static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        for (int i = 0; i < L; i++) {
            String studentId = br.readLine();
            map.put(studentId, i);
        }

    }

}