class Solution {
    fun solution(nums: IntArray): Int {
        var answer = 0
        var sumList = listOf<Int>(0, 0, 0)
        
        for (i in nums.indices) {
            for (j in i+1 until nums.size) {
                for (k in j+1 until nums.size) {
                    sumList = sumList.plus(nums[i] + nums[j] + nums[k])
                }
            }
        }
        
        sumList.forEach { sum ->
            var result = false
            for (i in 2 until sum) {
                if (sum % i == 0) {
                    result = false
                    break
                } else {
                    result = true
                }
            }
            if (result) answer++
        }
        
        return answer
    }
}