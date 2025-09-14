var n = 0
var k = 0
var pArr = intArrayOf()
var mL = listOf<Int>()
var result = 0

fun main() {
    val (N, K) = readln().split(" ").map { it.toInt() }

    n = N
    k = K
    pArr = IntArray(n)

    for (i in 0 until n - 1) {
        val (p, c) = readln().split(" ").map { it.toInt() }
        pArr[c] = p
    }

    mL = readln().split(" ").map { it.toInt() }

    calc(1, mutableSetOf(0))

    println(result)
}

fun calc(num: Int, set: MutableSet<Int>) {
    if (num == n) {
        for (i in 1 until n) {
            if (set.contains(i) && !set.contains(pArr[i])) return
        }

        var aCnt = 0
        var pCnt = 0

        for (i in set) {
            if (mL[i] == 1) aCnt++ else if (mL[i] == 2) pCnt++
        }

        if (aCnt <= k) {
            result = maxOf(result, pCnt)
        }
        
        return
    }

    calc(num + 1, set)
    set.add(num)
    calc(num + 1, set)
    set.remove(num)
}