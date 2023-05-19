class Solution {
    fun solution(num_list: IntArray): Int {
        val evenSum = num_list.filterIndexed { idx, _ -> idx % 2 == 0 }.sum()
        return maxOf(evenSum, num_list.sum() - evenSum)
    }
}