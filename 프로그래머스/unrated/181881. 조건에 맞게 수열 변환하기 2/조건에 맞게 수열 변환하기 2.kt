class Solution {
    fun solution(arr: IntArray): Int {
        var answer = 0
        var prev = arr

        while (true) {
            val temp = prev.map {
                when {
                    it >= 50 && it % 2 == 0 -> it / 2
                    it < 50 && it % 2 == 1 -> it * 2 + 1
                    else -> it
                }
            }.toIntArray()
            
            if (prev.contentEquals(temp)) break

            prev = temp
            answer++
        }

        return answer
    }
}