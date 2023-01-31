import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static StringBuilder sb;
    private static StringTokenizer st;

    static class Element {
        int idx;
        int num;

        public Element(int idx, int num) {
            this.idx = idx;
            this.num = num;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        int[] cnt = new int[1000001];
        int[] result = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            cnt[arr[i]]++;
        }
        Stack<Element> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            while(!stack.isEmpty()){
                Element element = stack.peek();
                if (cnt[element.num] < cnt[arr[i]]) {
                    result[element.idx] = arr[i];
                    stack.pop();
                }else{
                    break;
                }
            }
            stack.push(new Element(i, arr[i]));
        }

        while(!stack.isEmpty()){
            Element element = stack.pop();
            result[element.idx]=-1;
        }

        Arrays.stream(result)
                .forEach(i->sb.append(i+" "));
        System.out.print(sb.toString());
    }


}