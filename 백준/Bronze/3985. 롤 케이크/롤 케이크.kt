fun main() {
    val l = readln().toInt()
    val n = readln().toInt()
    val arrl = BooleanArray(l)
    val arrn = IntArray(n)
    var maxf = intArrayOf(0, 0)
    var maxl = intArrayOf(0, 0)

    repeat(n) {
        val (p, k ) = readln().split(' ').map(String::toInt)
        if (k - p > maxf[0]) maxf = intArrayOf(k - p, it + 1)
        for (i in p - 1 until k) {
            if (!arrl[i]) {
                arrn[it]++
                arrl[i] = true
            }
        }
        if (arrn[it] > maxl[0]) maxl = intArrayOf(arrn[it], it + 1)
    }

    println("${maxf[1]}\n${maxl[1]}")
}