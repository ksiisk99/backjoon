import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static class Pillar implements Comparable<Pillar> {
        int L, H;

        public Pillar(int l, int h) {
            L = l;
            H = h;
        }

        @Override
        public int compareTo(Pillar o) {
            return L - o.L;
        }
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        Pillar[] pillars = new Pillar[N];
        int maxH = 0, maxIdx = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());
            pillars[i] = new Pillar(L, H);
            if (H > maxH) {
                maxH = H;
            }
        }

        Arrays.sort(pillars);

        for (int i = 0; i < pillars.length; i++) {
            if (pillars[i].H == maxH) {
                maxIdx = i;
                break;
            }
        }

        int result = 0;
        Stack<Pillar> stack = new Stack<>();
        int tmpMaxH = 0;
        int tmpMaxL = 0;
        for (int i = 0; i <= maxIdx; i++) {
            if (tmpMaxH < pillars[i].H) {
                result += tmpMaxH * (pillars[i].L - tmpMaxL);
                tmpMaxH = pillars[i].H;
                tmpMaxL = pillars[i].L;
            }
        }

        tmpMaxH = 0;
        tmpMaxL = 0;
        for (int i = N - 1; i >= maxIdx; i--) {
            if (tmpMaxH <= pillars[i].H) {
                result += tmpMaxH * (tmpMaxL - pillars[i].L);
                tmpMaxH = pillars[i].H;
                tmpMaxL = pillars[i].L;
            }
        }


        System.out.print(result + maxH);
    }
}
