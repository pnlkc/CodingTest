import java.util.StringTokenizer
import kotlin.math.ceil
import kotlin.math.ln
import kotlin.math.pow

var tree = intArrayOf()

fun main() {
    val sb = StringBuilder()
    val T = readln().toInt()

    p@ for (tc in 1..T) {
        val N = readln().toInt()
        val st = StringTokenizer(readln())
        val list = IntArray(N + 1)
        val map = mutableMapOf<Int, Int>()

        for (i in 1..N) {
            list[i] = st.nextToken().toInt()
        }

        val h = ceil(ln(N.toDouble()) / ln(2.0))
        val cnt = 2.0.pow(h + 1).toInt()
        tree = IntArray(cnt)

        init(list, 1, 1, N)

        for (i in 1..N) {
            if (map[list[i]] != null) {
                val max = calc(1, 1, N, map[list[i]]!!, i)

                if (max > list[i]) {
                    sb.appendLine("No")
                    continue@p
                }
            }

            map[list[i]] = i
        }

        sb.appendLine("Yes")
    }

    print(sb)
}

fun init(list: IntArray, n: Int, s: Int, e: Int) {
    if (s == e) {
        tree[n] = list[s]
        return
    }

    init(list, n * 2, s, (s + e) / 2)
    init(list, n * 2 + 1, (s + e) / 2 + 1, e)
    tree[n] = maxOf(tree[n * 2], tree[n * 2 + 1])
}

fun calc(n: Int, s: Int, e: Int, l: Int, r: Int): Int {
    if (l > e || r < s) return 0
    if (l <= s && r >= e) return tree[n]

    val lM = calc(n * 2, s, (s + e) / 2, l, r)
    val rM = calc(n * 2 + 1, (s + e) / 2 + 1, e, l, r)

    return maxOf(lM, rM)
}