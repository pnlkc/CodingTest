class Solution {
    fun solution(n: Int, control: String): Int {
        return control.fold(n) { acc, c ->
            when (c) {
                'w' -> acc + 1
                's' -> acc - 1
                'd' -> acc + 10
                else -> acc - 10
            }
        }
    }
}