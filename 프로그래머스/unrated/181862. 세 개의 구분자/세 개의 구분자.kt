class Solution {
    fun solution(myStr: String): Array<String> {
        return myStr
            .split("a", "b", "c")
            .filter { it.isNotEmpty() }
            .toTypedArray()
            .ifEmpty { arrayOf("EMPTY") }
    }
}