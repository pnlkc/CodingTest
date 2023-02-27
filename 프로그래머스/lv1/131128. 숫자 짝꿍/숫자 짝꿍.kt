class Solution {
    fun solution(X: String, Y: String): String {
        val string = StringBuilder()
        for (i in 9 downTo 0) {
            repeat(minOf(X.count { it.toString().toInt() == i },
                Y.count { it.toString().toInt() == i })) {
                string.append(i)
            }
        }
        return when {
            string.isEmpty() -> "-1"
            string.length == string.count { it == '0' } -> "0"
            else -> string.toString()
        }
    }
}
