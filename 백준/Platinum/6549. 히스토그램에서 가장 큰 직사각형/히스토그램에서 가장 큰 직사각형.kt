import java.util.StringTokenizer

fun main() {
    val sb = StringBuilder()

    while(true) {
        val input = readln()
        if (input == "0") break
        val st = StringTokenizer(input)
        val arr = IntArray(st.nextToken().toInt()) { st.nextToken().toInt() }

        sb.appendLine(calc(0, arr.lastIndex, arr))
    }

    println(sb.toString())
}

fun calc(s: Int, e: Int, arr: IntArray): Long {
    return when (s) {
        e -> arr[s].toLong()
        else -> {
            val mid = (s + e) / 2
            var l = mid
            var r = mid
            var mH = arr[mid]
            var cM = arr[mid].toLong()

            while (l >= s && r <= e) {
                mH = minOf(mH, minOf(arr[l], arr[r]))
                cM = maxOf(cM, mH.toLong() * (r - l + 1))

                when {
                    l == s -> r++
                    r == e -> l--
                    arr[l - 1] > arr[r + 1] -> l--
                    else -> r++
                }
            }

            val lM = if (mid - 1 < s) 0L else calc(s, mid - 1, arr)
            val rM = if (mid + 1 > e) 0L else calc(mid + 1, e, arr)

            maxOf(cM, lM, rM)
        }
    }
}