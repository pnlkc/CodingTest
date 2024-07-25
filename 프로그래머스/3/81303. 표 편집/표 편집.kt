class Solution {
    fun solution(n: Int, k: Int, cmd: Array<String>): String {
        val answer = StringBuilder()
        val deleteList = mutableListOf<Int>()
        var s = k
        for (c in cmd) {
            when (c[0]) {
                'U' -> s -= c.split(" ")[1].toInt()
                'D' -> s += c.split(" ")[1].toInt()
                'C' -> {
                    deleteList.add(s)
                    if (n - deleteList.size == s) s--
                }
                'Z' -> {
                    if (deleteList.last() <= s) s++
                    deleteList.removeLast()
                }
            }
        }
        repeat(n - deleteList.size) { answer.append('O') }
        for (i in deleteList.lastIndex downTo 0) { answer.insert(deleteList[i], 'X') }
        return answer.toString()
    }
}