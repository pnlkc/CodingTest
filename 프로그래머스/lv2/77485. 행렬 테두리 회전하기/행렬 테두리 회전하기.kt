class Solution {
    fun solution(rows: Int, columns: Int, queries: Array<IntArray>): IntArray {
        var answer = intArrayOf()

        var originList = Array(rows) { IntArray(columns) }
        var num = 1

        for (i in 0 until rows ) {
            for (j in 0 until columns) {
                originList[i][j] = num
                num++
            }
        }

        queries.forEach {
            var num = originList[it[0]-1][it[1]-1]
            var num2 = 0
            for (i in it[1] until it[3]) {
                num2 = originList[it[0]-1][i]
                originList[it[0]-1][i] = num
                num = num2
            }

            for (i in it[0] until it[2]) {
                num2 = originList[i][it[3]-1]
                originList[i][it[3]-1] = num
                num = num2
            }

            for (i in it[3]-1 downTo it[1]) {
                num2 = originList[it[2]-1][i-1]
                originList[it[2]-1][i-1] = num
                num = num2
            }

            for (i in it[2]-1 downTo it[0]) {
                num2 = originList[i-1][it[1]-1]
                originList[i-1][it[1]-1] = num
                num = num2
            }

            var numList = intArrayOf()

            for (i in it[1]..it[3]) {
                numList += originList[it[0]-1][i-1]
                numList += originList[it[2]-1][i-1]
            }

            for (i in it[0]..it[2]) {
                numList += originList[i-1][it[1]-1]
                numList += originList[i-1][it[3]-1]
            }

            answer += numList.minOrNull()!!
        }

        return answer
    }
}