class Solution {
    fun generate(numRows: Int): List<List<Int>> {
        val result = mutableListOf<MutableList<Int>>()

        for (i in 1..numRows) {
            result.add(MutableList<Int>(i) { 1 })
        }

        for (i in 1 until numRows) {
            for (j in 1 until i) {
                result[i][j] = result[i - 1][j - 1] + result[i - 1][j]
            }
        }

        return result
    }
}