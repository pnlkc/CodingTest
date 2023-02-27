class Solution {
    fun solution(num_list: IntArray, n: Int): Array<IntArray> {
        val answer = mutableListOf<IntArray>()
        var i = 0
        while (i < num_list.size) {
            answer.add(num_list.slice(i until i + n).toIntArray())
            i += n
        }
        return answer.toTypedArray()
    }
}