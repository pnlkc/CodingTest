import java.util.Arrays;

class Solution
{
    public int solution(int []A, int []B)
    {
    	int sum = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        for (int i = 0; i < A.length; i++) {
        	sum += A[i] * B[B.length - 1 - i];
        }
        return sum;
    }
}