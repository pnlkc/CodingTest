class Solution {
    var answer = -1

    fun solution(x: Int, y: Int, n: Int): Int {
        calc(mutableSetOf(x), y, n)
        return answer
    }

    fun calc(list: MutableSet<Int>, y: Int, n: Int, count: Int = 0) {
        if (list.contains(y)) {
            answer = count
        } else if (list.count { it < y } != 0) {
            val temp = mutableSetOf<Int>()
            list.filter { it < y }.forEach {
                temp.add(it * 2)
                temp.add(it * 3)
                temp.add(it + n)
            }
            calc(temp, y, n, count + 1)
        }
    }
}