class Solution {
    fun solution(my_string: String, indices: IntArray): String {
        return my_string.foldIndexed("") { idx, acc, c -> if (indices.contains(idx)) acc else acc + c }
    }
}