import kotlin.math.sqrt

fun main() {
    val sb = StringBuilder()
    val t = readln().toInt()

    for (tc in 0 until t) {
        val str = readln()
        val n = sqrt(str.length.toDouble()).toInt()

        for (i in n - 1 downTo 0) {
            var idx = i

            while (idx < str.length) {
                sb.append(str[idx])
                idx += n
            }
        }

        sb.appendLine()
    }

    print(sb)
}