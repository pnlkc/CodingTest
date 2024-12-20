import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        char[] S = br.readLine().toCharArray();
        boolean[] isDelete = new boolean[S.length];
        int zeroCnt = 0;
        int oneCnt = 0;

        for (char c : S) {
            if (c == '0') zeroCnt++;
            else oneCnt++;
        }

        zeroCnt /= 2;
        oneCnt /= 2;

        for (int i = 0; i < S.length; i++) {
            if (S[i] == '1') {
                isDelete[i] = true;

                if (--oneCnt == 0) break;
            }
        }

        for (int i = S.length - 1; i >= 0; i--) {
            if (S[i] == '0') {
                isDelete[i] = true;

                if (--zeroCnt == 0) break;
            }
        }

        for (int i = 0; i < S.length; i++) {
            if (S[i] == '1') {
                if (!isDelete[i]) {
                    sb.append('1');
                }
            } else {
                if (!isDelete[i]) {
                    sb.append('0');
                }
            }
        }

        System.out.println(sb);
    }
}
