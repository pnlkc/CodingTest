class Solution {
    fun solution(n: Int): Long {
        val list = mutableListOf(0L, 1L, 1L)
        while (list.size - 2 != n) { 
            list.add(list[list.lastIndex] % 1234567 + list[list.lastIndex - 1] % 1234567) 
        }
        return list.last() % 1234567
    }
}