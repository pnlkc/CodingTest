class Solution {
    public int solution(String[] strArr) {
        int[] arr = new int[31];
        int max = 0;
        for (String str : strArr) {
            max = Math.max(max, ++arr[str.length()]);
        }
        return max;
    }
}