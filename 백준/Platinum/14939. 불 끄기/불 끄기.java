import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static StringBuilder sb = new StringBuilder();

    private static int turn(int[] bit) {
        int result = Integer.MAX_VALUE;

        for (int step = 0; step < 1024; step++) {
            int[] tmpBit = new int[10];
            for (int i = 0; i < 10; i++) {
                tmpBit[i] = bit[i];
            }
            int cnt = 0;
            for (int i = 0; i < 10; i++) {
                if ((step & (1 << i)) > 0) {
                    cnt++;
                    if ((bit[0] & (1 << i)) > 0) {
                        bit[0] &= (~(1 << i));
                    } else {
                        bit[0] |= (1 << i);
                    }

                    if ((bit[1] & (1 << i)) > 0) {
                        bit[1] &= (~(1 << i));
                    } else {
                        bit[1] |= (1 << i);
                    }

                    if (i == 0) {
                        if ((bit[0] & (1 << (i + 1))) > 0) {
                            bit[0] &= (~(1 << (i + 1)));
                        } else {
                            bit[0] |= (1 << (i + 1));
                        }
                    } else if (i == 9) {
                        if ((bit[0] & (1 << (i - 1))) > 0) {
                            bit[0] &= (~(1 << (i - 1)));
                        } else {
                            bit[0] |= (1 << (i - 1));
                        }
                    } else {
                        if ((bit[0] & (1 << (i + 1))) > 0) {
                            bit[0] &= (~(1 << (i + 1)));
                        } else {
                            bit[0] |= (1 << (i + 1));
                        }

                        if ((bit[0] & (1 << (i - 1))) > 0) {
                            bit[0] &= (~(1 << (i - 1)));
                        } else {
                            bit[0] |= (1 << (i - 1));
                        }
                    }
                }
            }

            for (int i = 1; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if ((bit[i - 1] & (1 << j)) > 0) {
                        cnt++;
                        bit[i - 1] &= (~(1 << j));
                        if ((bit[i] & (1 << j)) > 0) {
                            bit[i] &= (~(1 << j));
                        } else {
                            bit[i] |= (1 << j);
                        }

                        if (j > 0) {
                            if ((bit[i] & (1 << (j - 1))) > 0) {
                                bit[i] &= (~(1 << (j - 1)));
                            } else {
                                bit[i] |= (1 << (j - 1));
                            }
                        }
                        if (j < 9) {
                            if ((bit[i] & (1 << (j + 1))) > 0) {
                                bit[i] &= (~(1 << (j + 1)));
                            } else {
                                bit[i] |= (1 << (j + 1));
                            }
                        }

                        if (i != 9) {
                            if ((bit[i + 1] & (1 << j)) > 0) {
                                bit[i + 1] &= (~(1 << j));
                            } else {
                                bit[i + 1] |= (1 << j);
                            }
                        }
                    }
                }
            }

            for (int i = 0; i < 10; i++) {
                if ((bit[9] & (1 << i)) > 0) {
                    cnt = Integer.MAX_VALUE;
                    break;
                }
            }
            result = Math.min(result, cnt);

            for (int i = 0; i < 10; i++) {
                bit[i] = tmpBit[i];
            }
        }


        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[] bit = new int[10];
        for (int i = 0; i < 10; i++) {
            String s = br.readLine();
            for (int j = 0; j < 10; j++) {
                char c = s.charAt(j);
                if (c == 'O') {
                    bit[i] |= (1 << j);
                }
            }
        }

        System.out.print(turn(bit));
    }


}