class Solution {


    fun solution(brown: Int, yellow: Int): IntArray {
        var column = 3
        var row = 3

        while (column * row != brown + yellow || (column - 2) * (row - 2) != yellow) {
            column++
            if (column * row > brown + yellow) {
                column = 3
                row++
            }
        }

        return intArrayOf(column, row)
    }
}