class Solution {
    var answer: IntArray = intArrayOf(0, 0)
    fun solution(users: Array<IntArray>, emoticons: IntArray): IntArray {
        val mapE = emoticons.map {
            intArrayOf(it - (it / 10), it - (it / 10 * 2), it - (it / 10 * 3), it - (it / 10 * 4))
        }
        calc(users, mapE)
        return answer
    }

    fun calc(
        users: Array<IntArray>,
        list: List<IntArray>,
        discountA: IntArray = intArrayOf(),
        costA: IntArray = intArrayOf(),
        i: Int = 0,
    ) {
        if (i <= list.lastIndex) {
            calc(users, list, discountA + 10, costA + list[i][0], i + 1)
            calc(users, list, discountA + 20, costA + list[i][1], i + 1)
            calc(users, list, discountA + 30, costA + list[i][2], i + 1)
            calc(users, list, discountA + 40, costA + list[i][3], i + 1)
        } else {
            val a = intArrayOf(0, 0)
            users.forEach {
                var sum = 0
                for (i in discountA.indices) {
                    if (discountA[i] >= it[0]) {
                        sum += costA[i]
                    }
                }
                if (sum >= it[1]) a[0]++ else a[1] += sum
            }
            if (a[0] > answer[0]) answer = a
            else if (a[0] == answer[0] && a[1] > answer[1]) answer = a
        }
    }
}