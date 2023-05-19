class Solution {
    fun solution(names: Array<String>): Array<String> {
        return (names.indices step 5).map { names[it] }.toTypedArray()
    }
}