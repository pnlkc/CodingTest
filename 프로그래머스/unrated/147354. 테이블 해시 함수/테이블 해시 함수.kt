class Solution {
    fun solution(data: Array<IntArray>, col: Int, row_begin: Int, row_end: Int): Int {
        data.sortWith(compareBy<IntArray> { it[col - 1] }.thenByDescending { it[0] })
        val map = data.mapIndexed { idx, ints ->
            if (idx in row_begin - 1 until row_end) {
                ints.map { it % (idx + 1) }.sum()
            } else {
                ints.sum()
            }
        }
        
        var answer = map[row_begin - 1]
        for (i in row_begin until row_end) {
            answer = answer xor map[i]
        }
        return answer
    }
}