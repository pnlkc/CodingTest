import kotlin.math.abs

fun main() {
    val sb = StringBuilder()
    val N = 100_000
    val pL = initPrimeList(N)
    val T = readln().toInt()

    for (tc in 1..T) {
        val n = readln().toInt()
        val list = readln().split(" ").map { it.toInt() }.sorted()

        val minIdx = maxOf(0, pL.indexOfFirst { it >= list.first() } - 1)
        val maxIdx = maxOf(0, pL.indexOfFirst { it >= list.last() } - n + 1)
        var min = Int.MAX_VALUE

        for (i in minIdx..maxIdx) {
            var sum = 0

            for(j in i until i + n) {
                sum += abs(list[j - i] - pL[j])
            }

            min = minOf(min, sum)
        }

        sb.appendLine(min)
    }

    print(sb)
}

fun initPrimeList(n: Int): MutableList<Int> {
    val pL = BooleanArray(n + 1) { true }
    pL[0] = false
    pL[1] = false

    for (i in 2.. n) {
        var num = i + i

        while (num <= n) {
            pL[num] = false
            num += i
        }
    }

    val pList = mutableListOf<Int>()

    for (i in 2..n) {
        if (pL[i]) pList.add(i)
    }

    return pList
}