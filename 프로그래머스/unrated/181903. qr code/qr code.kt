class Solution {
    fun solution(q: Int, r: Int, code: String): String {
        return code.foldIndexed("") { idx, acc, c -> if (idx % q == r) acc + c else acc }
    }
}