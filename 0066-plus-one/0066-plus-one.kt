class Solution {
    fun plusOne(digits: IntArray): IntArray {
        for (i in digits.lastIndex downTo 0) {
            if (digits[i] == 9) {
                digits[i] = 0
            } else {
                digits[i]++
                break
            }
        }
        
        return if (digits[0] == 0) intArrayOf(1) + digits else digits
    }
}