class Solution {
    fun solution(num_list: IntArray): Int {
        return num_list.sumOf { calc(it) }
    }
    
    fun calc(n: Int): Int {
        var temp = n
        var result = 0
        
        while (temp != 1) {
            if (temp % 2 == 0) temp /= 2 else temp = (temp - 1) / 2
            result++
        }
        
        return result
    }
}