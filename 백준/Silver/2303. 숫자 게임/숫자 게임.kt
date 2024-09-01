var r = 0

fun main() {
    val N = readln().toInt()
    val arr = Array(N) { listOf<Int>() }
    val result = IntArray(N)

    for (i in 0 until N) {
        arr[i] = readln().split(" ").map { it.toInt() }
    }

    for (i in 0 until N) {
        r = 0
        calc(arr[i], 0, 0, 0)
        result[i] = r
    }

    val max = result.max()
    
    println(result.indexOfLast { it == max } + 1)
}

fun calc(list: List<Int>, idx: Int, cnt: Int, sum: Int) {
    if (idx == 5) {
        if (cnt == 3) r = maxOf(r, sum)
        return
    }

    calc(list, idx + 1, cnt, sum)
    calc(list, idx + 1, cnt + 1, (sum + list[idx]) % 10)
}