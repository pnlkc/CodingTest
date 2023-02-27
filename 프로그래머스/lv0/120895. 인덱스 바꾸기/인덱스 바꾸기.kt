class Solution {
    fun solution(my_string: String, num1: Int, num2: Int): String {
        return my_string.mapIndexed { index, c -> 
            when (index) {
                num1 -> my_string[num2]
                num2 -> my_string[num1]
                else -> c
            }
        }.joinToString("")
    }
}