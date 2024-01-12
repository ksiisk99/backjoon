import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static int N, M;


    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        boolean isGooooooooooooooooooooooooooooooooooooooooooooooooooood = true;
        for (int i = 0; i < M; i++) {
            int MIN = Integer.MAX_VALUE;
            int size = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int s = 0; s < size; s++) {
                int num = Integer.parseInt(st.nextToken());
                if (MIN > num) {
                    MIN = num;
                } else {
                    isGooooooooooooooooooooooooooooooooooooooooooooooooooood = false;
                }
            }
        }

        if (isGooooooooooooooooooooooooooooooooooooooooooooooooooood) {
            System.out.print("Yes");
        } else {
            System.out.print("No");
        }

    }

    private static void input() throws IOException {


    }

}