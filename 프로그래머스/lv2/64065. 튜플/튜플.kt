class Solution {
    fun solution(s: String): IntArray {
        var answer = intArrayOf()
        var set = mutableSetOf<String>()
        val list = mutableListOf<List<String>>()

        s.removeSurrounding("{{", "}}").split("},{").sortedBy { it.length }.forEach {
            list.add(it.split(","))
        }

        list.forEach { set.addAll(it) }

        set.forEach { answer += it.toInt() }

        return answer
    }
}