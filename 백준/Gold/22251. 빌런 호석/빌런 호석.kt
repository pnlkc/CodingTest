val map = intArrayOf(119, 18, 93, 91, 58, 107, 111, 82, 127, 123)

fun main() {
    val (N, K, P, X) = readln().split(" ").map { it.toInt() }
    var num = X.toString()
    var result = 0

    while (num.length < K) {
        num = "0$num"
    }

    p@ for (i in 1..N) {
        if (i == X) continue

        var cnt = 0
        var next = i.toString()

        while (next.length < K) {
            next = "0$next"
        }

        for (j in num.indices) {
            cnt += calcDiff(num[j].digitToInt(), next[j].digitToInt())
            if (cnt > P) continue@p
        }

        result++
    }
    
    println(result)
}

fun calcDiff(a: Int, b: Int): Int = (map[a] xor map[b]).countOneBits()