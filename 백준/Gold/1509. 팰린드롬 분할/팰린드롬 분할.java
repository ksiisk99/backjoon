import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    private static StringBuilder sb;
    private static StringTokenizer st;
    private static int size;

    private static boolean[][] calcPalindrome(String s) {
        boolean[][] palindrome = new boolean[size+1][size+1];

        for (int i = 1; i <= size; i++) {
            palindrome[i][i] = true;
        }

        for (int i = 1; i < size; i++) {
            if (s.charAt(i) == s.charAt(i+1)) {
                palindrome[i][i + 1] = true;
            }
        }

        for (int len = 3; len <= size; len++) {
            for (int start = 1; start <= size - len + 1; start++) {
                int end = start + len - 1;
                if (s.charAt(start ) == s.charAt(end) && palindrome[start + 1][end - 1]) {
                    palindrome[start][end] = true;
                }
            }
        }

        return palindrome;
    }

    private static int calcDp(boolean[][] palindrome, String s) {
        int[] dp = new int[size+1];

        for (int end = 1; end <= size; end++) {
            dp[end] = Integer.MAX_VALUE;
            for (int start = 1; start <= end; start++) {
                if (palindrome[start][end]) {
                    dp[end] = Math.min(dp[end], dp[start - 1] + 1);
                }
            }
        }

        return dp[size];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        String s = br.readLine();
        size=s.length();
        s = " " + s;
        System.out.println(calcDp(calcPalindrome(s), s));

    }
}