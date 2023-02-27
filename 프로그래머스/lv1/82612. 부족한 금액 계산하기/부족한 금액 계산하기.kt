class Solution {
    fun solution(price: Int, money: Int, count: Int): Long {
        var answer: Long = -1
        var sum: Long = 0
        for (i in 1..count) {
            sum = sum + price * i
        }
        
        if (sum < money) answer = 0 else answer = sum - money
        
        return answer
    }
}