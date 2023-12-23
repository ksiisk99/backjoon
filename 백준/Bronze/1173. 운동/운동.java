import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static int N; //필요한 운동 시간
    private static int m; //초기 맥박
    private static int M; //최대 맥박
    private static int T; //운동 후 맥박 증가량
    private static int R; //휴식 후 맥박 감소량
    private static int 영식;

    public static void main(String[] args) throws IOException {
        input();
        if ((M - m) < T) {
            System.out.println(-1);
            return;
        }

        영식 = m;
        int answer = N;
        while (N > 0) {
            if (canExercise()) {
                영식 += T;
                N--;
                continue;
            }

            answer += rest();
        }

        System.out.print(answer);
    }

    private static int rest() {
        int desiredPulse = (영식 + T) - M;
        int restTime = 0;

        while (desiredPulse > 0) {
            desiredPulse -= R;
            restTime++;
            
            if (isHigherThanInitialPulse()) {
                영식 -= R;
            } else {
                영식 = m;
            }
        }

        return restTime;
    }

    private static boolean canExercise() {
        if (영식 + T <= M) {
            return true;
        }
        return false;
    }

    private static boolean isHigherThanInitialPulse() {
        if ((영식 - R) >= m) {
            return true;
        }

        return false;
    }

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
    }
}