import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.FileInputStream;

class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        StringTokenizer st = new StringTokenizer("");

        sc.nextLine();

        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(sc.nextLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int cnt = 0;

            while (n >= a && n >= b) {
                if (a >= b) {
                    b += a;
                } else {
                    a += b;
                }

                cnt++;
            }

            System.out.println(cnt);
        }
    }
}