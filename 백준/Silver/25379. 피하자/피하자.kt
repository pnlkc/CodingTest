fun main() {
    val N = readln().toInt()
    val list = readln().split(" ").map { it.toInt() }
    val isEven = list[0] % 2 == 0
    var s = 0
    var l = N - 1
    var cntS = 0L
    var cntL = 0L

    for (i in 0 until N) {
        if ((list[i] % 2 == 0) != isEven) continue

        cntS += i - s
        s++
    }

    for (i in N - 1 downTo 0) {
        if ((list[i] % 2 == 0) != isEven) continue

        cntL += l - i
        l--
    }

    println(minOf(cntS, cntL))
}