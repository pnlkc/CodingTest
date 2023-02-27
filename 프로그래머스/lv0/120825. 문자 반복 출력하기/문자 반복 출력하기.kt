class Solution {
    fun solution(my_string: String, n: Int): String {
        return my_string.toCharArray().joinToString("") { char ->
            var result = ""
            repeat (n) { result += char }
            result
        }
    }
}