import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    public static void main(String[] args) throws IOException {
        //input();
        String s = br.readLine();
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i) - 'A']++;
        }

        int n = 0;
        int idx = -1;
        for (int i = 0; i < 26; i++) {
            if (cnt[i] % 2 == 1) {
                n++;
                idx = i;
            }
        }

        if (n >= 2) {
            System.out.print("I'm Sorry Hansoo");
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (cnt[i] == 0) {
                continue;
            }

            while (cnt[i] != 0) {
                if(idx==i && cnt[i]==1) {
                    break;
                }

                if (sb.length() == 0) {
                    sb.append((char)(i + 'A'));
                    cnt[i]--;
                }

                int size = ((sb.length() - 1) / 2) + 1;
                sb.insert(size, (char) (i + 'A'));
                cnt[i]--;

            }
        }

        if(idx != -1) {
            if (sb.length() == 0) {
                sb.append((char)(idx + 'A'));
            } else {
                int size = ((sb.length() - 1) / 2) + 1;
                sb.insert(size, (char) (idx + 'A'));
            }

        }

        System.out.print(sb.toString());
    }

    public static void input() throws IOException {
        StringTokenizer st;

    }
}