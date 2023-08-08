class Solution {
    public int solution(String num_str) {
        int r = 0;
        for (int i = 0; i < num_str.length(); i++) {
            r += Integer.parseInt(String.valueOf(num_str.charAt(i)));
        }
        return r;
    }
}