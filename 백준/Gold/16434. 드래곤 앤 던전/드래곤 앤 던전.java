import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N, atk;
    private static List<Room> rooms = new ArrayList<>();

    static class Room {
        int type;
        int atk;
        int hp;

        public Room(int type, int atk, int hp) {
            this.type = type;
            this.atk = atk;
            this.hp = hp;
        }
    }


    public static void main(String[] args) throws IOException {
        input();

        long left = 0L;
        long right = Long.MAX_VALUE;

        while (left <= right) {
            long mid = (left + right) / 2;
            long tmpAtk = atk;

            if (isFinish(tmpAtk, mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.print(left);
    }

    private static boolean isFinish(long attack, long hp) {
        long maxHp = hp;

        for (Room room : rooms) {
            if (room.type == 1) {
                long cnt = (long) Math.floor(room.hp / attack);
                if (room.hp % attack == 0) {
                    cnt--;
                }

                hp -= (room.atk * cnt);
                if (hp <= 0) {
                    return false;
                }
            } else {
                attack += room.atk;
                hp += room.hp;
                if (hp > maxHp) {
                    hp = maxHp;
                }
            }
        }

        return true;
    }

    public static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        atk = Integer.parseInt(st.nextToken());


        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            rooms.add(new Room(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

    }

}