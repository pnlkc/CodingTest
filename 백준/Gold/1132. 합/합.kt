import java.util.LinkedList

fun main() {
    val N = readln().toInt()
    val map = mutableMapOf(
        'A' to 0L, 'B' to 0L, 'C' to 0L, 'D' to 0L, 'E' to 0L,
        'F' to 0L, 'G' to 0L, 'H' to 0L, 'I' to 0L, 'J' to 0L,
    )
    val cnt = Array(12) { IntArray(10) }
    val canZero = BooleanArray(10) { true }

    for (i in 0 until N) {
        val num = readln()

        canZero[num[0] - 'A'] = false

        for (j in num.indices) {
            cnt[12 - num.length + j][num[j] - 'A']++

            var addNum = 1L

            repeat(num.length - j - 1) { addNum *= 10 }
            map[num[j]] = map[num[j]]!! + addNum
        }
    }

    val list = map.keys.sortedByDescending { map[it] }

    val q = LinkedList<Int>()
    val dq = LinkedList<Int>()
    var isEnd = false

    for (i in 9 downTo 0) {
        val num = list[i] - 'A'

        if (!canZero[num]) {
            if (!isEnd) q.addFirst(num) else dq.addFirst(num)
        } else {
            if (!isEnd) {
                while (q.isNotEmpty()) {
                    dq.addLast(q.poll()!!)
                }

                dq.addLast(num)
                isEnd = true
            } else {
                dq.addFirst(num)
            }
        }
    }

    var result = 0L
    var num = 9

    while (dq.isNotEmpty()) {
        val c = 'A' + dq.poll()!!
        
        result += num-- * map[c]!!
    }

    println(result)
}