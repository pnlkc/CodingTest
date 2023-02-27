class Solution {
    fun solution(phone_number: String): String {
        return phone_number.mapIndexed { i, c -> if (i in 0..phone_number.lastIndex-4) '*' else c }.joinToString("")
    }
}