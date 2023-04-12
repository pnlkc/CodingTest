import java.util.*

fun main() {
    repeat(readln().toInt()) {
        val k = readln().toInt()
        val st = StringTokenizer(readln())
        val arr = IntArray(k) { st.nextToken().toInt() }
        val memo = Array(k) { IntArray(k) }
        val sum = IntArray(k + 1)
        arr.forEachIndexed { idx, i -> sum[idx + 1] = sum[idx] + i }

        println(calc(arr, sum, memo, 0, k - 1))
    }
}

fun calc(arr: IntArray, sum: IntArray, memo: Array<IntArray>, s: Int, e: Int): Int {
    if (s == e) return arr[s]

    var result = Int.MAX_VALUE

    for (i in s until e) {
        val f = if(memo[s][i] != 0) memo[s][i] else calc(arr, sum, memo, s, i)
        val fSum = if (s != i) sum[i + 1] - sum[s] else 0
        val b = if(memo[i + 1][e] != 0) memo[i + 1][e] else calc(arr, sum, memo, i + 1, e)
        val bSum = if (e != i + 1) sum[e + 1] - sum[i + 1] else 0
        result = minOf(result, f + b + fSum + bSum)
    }

    memo[s][e] = result

    return result
}