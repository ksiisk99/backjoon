import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String str = br.readLine();

        int one = 0;
        int zero = 0;
        char tmp = str.charAt(0);
        if(tmp=='0'){
            zero++;
        }else{
            one++;
        }

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) != tmp) {
                if(str.charAt(i)=='0'){
                    zero++;
                }else{
                    one++;
                }
                tmp=str.charAt(i);
            }
        }

        System.out.println(Math.min(one, zero));
    }
}
