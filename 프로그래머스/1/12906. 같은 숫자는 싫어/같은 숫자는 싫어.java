import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        int lv = -1;
        
        for (int num : arr) {
            if (lv != num) {
                list.add(num);
                lv = num;
            }
        }

        int[] answer = new int[list.size()];
        
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}