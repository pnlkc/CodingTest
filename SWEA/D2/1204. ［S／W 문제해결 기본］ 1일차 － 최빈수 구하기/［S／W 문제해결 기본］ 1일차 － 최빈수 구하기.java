import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int tcNum = sc.nextInt();
            sc.nextLine();

            Scanner ls = new Scanner(sc.nextLine().trim());
            Map<Integer, Integer> map = new HashMap<>();

            while (ls.hasNextInt()) {
                int num = ls.nextInt();

                map.put(num, map.getOrDefault(num, 0) + 1);
            }

            int topKey = map.entrySet().stream()
                    .max(
                            Map.Entry.<Integer, Integer>comparingByValue()
                                    .thenComparing(Map.Entry.comparingByKey()))
                    .map(Map.Entry::getKey)
                    .orElse(0);

            System.out.println(String.format("#%d %d", tcNum, topKey));
        }
    }
}