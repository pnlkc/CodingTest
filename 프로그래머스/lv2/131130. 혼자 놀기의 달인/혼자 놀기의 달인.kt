class Solution {
    fun solution(cards: IntArray): Int {
        val answer = mutableListOf<Int>(0)
        var num = 0
        while (cards.count { it != 0 } != 0) {
            var index = cards.indexOfFirst { it != 0 }
            if (index == -1) break
            while (cards[index] != 0) {
                num++
                val newIndex = cards[index] -1
                cards[index] = 0
                index = newIndex
            }
            answer.add(num)
            num = 0
        }
        answer.sortDescending()
        return answer[0] * answer[1]
    }
}