class Solution {
    fun solution(bin1: String, bin2: String): String {
        return (bin1.toInt(2) + bin2.toInt(2)).toString(2)
    }
}