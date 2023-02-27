class Solution {
    fun solution(elements: IntArray): Int {
        val answer = mutableSetOf(elements.sum())
        for (i in elements.indices) {
            var sum = 0
            for (j in 0 until elements.lastIndex) {
                sum += if (i + j in elements.indices) {
                    elements[i + j]
                } else {
                    elements[i + j - elements.size]
                }
                answer.add(sum)
            }
            
        }
        return answer.size
    }
}