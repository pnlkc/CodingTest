import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int n = sc.nextInt();
            int result = 0;

            for (int i = 1; i <= n; i++) {
                if (i % 2 == 0) {
                    result -= i;
                } else {
                    result += i;
                }
            }

            System.out.println(String.format("#%d %d ", tc, result));
        }
    }
}