import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static StringBuilder sb = new StringBuilder();
    private static int R, C, M, fishingSharkSize;
    private static int[][] fishingHole;
    private static List<Shark> sharks;
    private static int[] dx = {0, -1, 1, 0, 0};
    private static int[] dy = {0, 0, 0, 1, -1};

    static class Shark {
        int x, y, s, d, z;

        public Shark(int x, int y, int s, int d, int z) {
            this.x = x;
            this.y = y;
            this.s = s;
            this.d = d;
            this.z = z;
        }
    }

    public static void main(String[] args) throws IOException {
        input();

        goFishing();

        System.out.print(fishingSharkSize);
    }

    private static void goFishing() {
        for (int i = 0; i < C; i++) {
            fishingSharkSize += fishingShark(i);
            moveShark();
        }
    }

    private static void moveShark() {
        int[][] tmpFishingHole = new int[R][C];
        List<Shark> tmpSharks = new ArrayList<>();
        tmpSharks.add(null);
        int sharkIndex = 1;

        for (int i = 1; i < sharks.size(); i++) {
            Shark shark = sharks.get(i);
            if (shark == null) {
                continue;
            }

            int x = shark.x;
            int y = shark.y;

            if (fishingHole[x][y] == 0) {
                continue;
            }
            int s = shark.s;
            int d = shark.d;

            for (int speed = 0; speed < s; speed++) {
                if (x == (R - 1) && d == 2) {
                    d = 1;
                } else if (x == 0 && d == 1) {
                    d = 2;
                } else if (y == (C - 1) && d == 3) {
                    d = 4;
                } else if (y == 0 && d == 4) {
                    d = 3;
                }
                x += dx[d];
                y += dy[d];
            }

            shark.x = x;
            shark.y = y;
            shark.d = d;

            if (tmpFishingHole[x][y] > 0) { //이미 그 자리에 상어가 존재하다면
                Shark tmpShark = tmpSharks.get(tmpFishingHole[x][y]);

                if (tmpShark.z < shark.z) {
                    tmpSharks.set(tmpFishingHole[x][y], shark);
                }
            } else {
                tmpSharks.add(shark);
                tmpFishingHole[x][y] = sharkIndex++;
            }
        }
        sharks = tmpSharks;
        copyFishingHole(tmpFishingHole);
    }

    private static void copyFishingHole(int[][] tmpFishingHole) {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                fishingHole[i][j] = tmpFishingHole[i][j];
            }
        }
    }

    private static int fishingShark(int col) {
        int sharkSize = 0;
        for (int i = 0; i < R; i++) {
            int sharkIndex = fishingHole[i][col];
            if (fishingHole[i][col] > 0) {
                Shark shark = sharks.get(sharkIndex);
                sharkSize = shark.z;
                fishingHole[i][col] = 0;
                break;
            }
        }
        return sharkSize;
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        sharks = new ArrayList<>();
        sharks.add(null); //인덱스 1로 시작하기 위해서 0은 null로 채워놓음
        fishingHole = new int[R][C];
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1; //행
            int y = Integer.parseInt(st.nextToken()) - 1; //열
            int s = Integer.parseInt(st.nextToken()); //속력
            int d = Integer.parseInt(st.nextToken()); //이동 방향
            int z = Integer.parseInt(st.nextToken()); //크기

            fishingHole[x][y] = i; //상어 인덱스
            sharks.add(new Shark(x, y, s, d, z));
        }


    }

}