class Solution {
    public int solution(int[] arr1, int[] arr2) {
        if (arr1.length == arr2.length) {
            int arr1Sum = 0;
            for (int i = 0; i < arr1.length; i++) {
                arr1Sum += arr1[i];
            }
            int arr2Sum = 0;
            for (int i = 0; i < arr2.length; i++) {
                arr2Sum += arr2[i];
            }
            if (arr1Sum > arr2Sum) {
                return 1;
            } else if (arr1Sum < arr2Sum) {
                return -1;
            } else {
                return 0;
            }
        } else if (arr1.length > arr2.length) {
            return 1;
        } else {
            return -1;
        }
    }
}