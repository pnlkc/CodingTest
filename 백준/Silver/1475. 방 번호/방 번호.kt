fun main() {
    val N = readln()
    val cnt = IntArray(10)

    for (i in N.indices) {
        cnt[N[i].digitToInt()]++
    }

    var both = (cnt[6] + cnt[9]) / 2
    if ((cnt[6] + cnt[9]) % 2 != 0) both++

    cnt[6] = both
    cnt[9] = both

    println(cnt.maxOrNull())
}