var arr = intArrayOf()
val map = intArrayOf(119, 18, 93, 91, 58, 107, 111, 82, 127, 123)
var result = 0
var n = 0
var k = 0
var p = 0
var x = 0

fun main() {
    val (N, K, P, X) = readln().split(" ").map { it.toInt() }

    arr = IntArray(K)
    n = N
    k = K
    p = P
    x = X

    var num = X.toString()

    while (num.length < K) {
        num = "0$num"
    }

    for (i in num.indices) {
        arr[i] = num[i].digitToInt()
    }

    calc(0, num, 0)

    println(result)
}

fun calcDiff(a: Int, b: Int): Int = (map[a] xor map[b]).countOneBits()

fun calc(idx: Int, num: String, cnt: Int) {
    if (cnt > p) return

    if (idx >= k) {
        val cNum = arr.joinToString("").toInt()
        
        if (cNum in 1..n && cNum != x) result++
        return
    }

    for (i in 0..9) {
        val nCnt = cnt + calcDiff(num[idx].digitToInt(), i)

        arr[idx] = i
        if (nCnt <= p) calc(idx + 1, num, nCnt)
    }
}