class Solution {
    fun solution(numbers: IntArray): IntArray {
        var answer: IntArray = intArrayOf()
        
        for (i in numbers.indices) {            
            for (j in i+1 until numbers.size) {
                answer = answer.plus(numbers[i] + numbers[j])
            }
        }
        
        answer = answer.distinct().sorted().toIntArray()
        
        return answer
    }
}