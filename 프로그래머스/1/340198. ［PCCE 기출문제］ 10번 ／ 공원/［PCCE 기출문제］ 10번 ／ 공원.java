import java.util.Arrays;

class Solution {
    public int solution(int[] mats, String[][] park) {
        int answer = -1;
        int r = park.length;
        int c = park[0].length;

        Arrays.sort(mats);
        
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (!park[i][j].equals("-1")) continue;
                int max = -1;

                p: for (int k : mats) {
                    for (int y = i; y < i + k; y++) {
                        for (int x = j; x < j + k; x++) {
                            if (y >= r || x >= c) break p;
                            if (!park[y][x].equals("-1")) break p;
                        }
                    }

                    max = Math.max(max, k);
                }

                answer = Math.max(answer, max);
            }
        }

        return answer;
    }
}