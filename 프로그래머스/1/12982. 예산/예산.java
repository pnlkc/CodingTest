import java.util.Arrays;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        int left = budget;

        Arrays.sort(d);

        for (int price : d) {
            if (left < price) break;

            left -= price;
            answer++;
        }

        return answer;
    }
}