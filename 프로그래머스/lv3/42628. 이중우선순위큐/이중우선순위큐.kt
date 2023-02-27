class Solution {
    fun solution(operations: Array<String>): IntArray {
        val list = mutableListOf<Int>()
        operations.forEach { operation ->
            when (operation) {
                "D 1" -> if (list.maxOrNull() != null) list.remove(list.maxOrNull())
                "D -1" -> if (list.minOrNull() != null) list.remove(list.minOrNull())
                else -> list.add(operation.slice(2..operation.lastIndex).toInt())
            }
        }
        return if (list.isEmpty()) intArrayOf(0, 0) else intArrayOf(list.maxOrNull()!!, list.minOrNull()!!)
    }
}