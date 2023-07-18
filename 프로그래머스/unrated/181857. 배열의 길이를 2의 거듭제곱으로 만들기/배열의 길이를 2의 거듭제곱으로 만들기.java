class Solution {
    public int[] solution(int[] arr) {
        int n = 1;
        
        while (n < arr.length) {
            n *= 2;
        }
        
        int[] answer = new int[n];
        System.arraycopy(arr, 0, answer, 0, arr.length);
        
        return answer;
    }
}