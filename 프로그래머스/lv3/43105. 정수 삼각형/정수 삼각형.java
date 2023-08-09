class Solution {
    public int solution(int[][] triangle) {
        int yL = triangle.length;
        int xL = triangle[triangle.length - 1].length;
        
        for (int i = yL - 2; i >= 0; i--) {
            for (int j = 0; j <= i ; j++) {
            	triangle[i][j] += Math.max(triangle[i + 1][j], triangle[i + 1][j + 1]);
            }            
        }
        
        return triangle[0][0];
    }
}