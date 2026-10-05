import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<String> list = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            String str = String.valueOf(i);
            int cnt = 0;

            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);

                if (c == '3' || c == '6' || c == '9') {
                    cnt++;
                }
            }

            if (cnt == 0) {
                list.add(String.valueOf(i));
            } else {
                StringBuilder sb = new StringBuilder();

                for (int j = 0; j < cnt; j++) {
                    sb.append('-');
                }

                list.add(sb.toString());
            }
        }

        System.out.println(String.join(" ", list));
    }
}