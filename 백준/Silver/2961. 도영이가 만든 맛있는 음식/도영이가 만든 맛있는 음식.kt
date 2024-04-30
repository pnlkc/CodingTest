import kotlin.math.abs

var result = Integer.MAX_VALUE

fun main() {
    val N = readln().toInt()
    val list = mutableListOf<Pair<Int, Int>>()

    for (i in 1..N) {
        val (a, b) = readln().split(" ").map { it.toInt() }

        list.add(a to b)
    }

    pick(1, N, list, 1, 0)
    pick(1, N, list, list[0].first, list[0].second)

    println(result)
}

fun pick (idx: Int, N: Int, list: MutableList<Pair<Int, Int>>, aSum: Int, bSum: Int) {
    if (idx == N)  {
        if (aSum != 0 && bSum != 0) result = minOf(result, abs(aSum - bSum))
        return
    }

    pick (idx + 1, N, list, aSum * list[idx].first, bSum + list[idx].second)
    pick(idx + 1, N, list, aSum, bSum)
}