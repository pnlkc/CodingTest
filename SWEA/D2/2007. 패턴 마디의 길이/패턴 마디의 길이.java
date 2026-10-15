import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());

        for (int tc = 1; tc <= T; tc++) {
            String str = br.readLine().trim();
            int result = 0;

            for (int i = 1; i <= 10; i++) {
                String pattern = str.substring(0, i);
                boolean isMatch = true;

                for (int j = 0; j < 30; j += i) {
                    if (j + i >= 30)
                        break;

                    String tmp = str.substring(j, j + i);

                    if (!pattern.equals(tmp)) {
                        isMatch = false;
                        break;
                    }
                }

                if (isMatch) {
                    result = i;
                    break;
                }
            }

            System.out.println(String.format("#%d %d", tc, result));
        }
    }
}