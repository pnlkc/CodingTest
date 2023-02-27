class Solution {
    fun solution(common: IntArray): Int {
        var answer= 0
        val check = booleanArrayOf(false, false)
        if (common[2] == common[1] + (common[1] - common[0])) check[0] = true
        else if (common[2] == common[1] * (common[1] / common[0])) check[1] = true
        when {
            check[0] -> answer = common.last() + (common[1] - common[0])
            check[1] -> answer = common.last() * (common[1] / common[0])
        }
        return answer
    }
}