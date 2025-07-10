import kotlin.math.pow

fun main() {
    val sb = StringBuilder()
    val T = readln().toInt()

    for (tc in 1..T) {
        val N = readln().toLong()
        var len = N.toString(2).length
        var num = N - 2.0.pow(len - 1).toLong() + 1

        while (len >= 1) {
            var str = num.toString()

            while (str.length < 18) {
                str = "0$str"
            }

            sb.appendLine("$len$str")
            len--
            num = if (num % 2 == 0L) num / 2 else num / 2 + 1
        }
    }

    print(sb)
}