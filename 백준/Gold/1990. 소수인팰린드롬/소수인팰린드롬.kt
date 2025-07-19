import kotlin.math.sqrt

fun main() {
    val sb = StringBuilder()
    val (a, b) = readln().split(" ").map { it.toInt() }
    val arr = BooleanArray(b + 1) { true }

    for (i in 2..sqrt(b.toDouble()).toInt() + 1) {
        if (!arr[i]) continue

        var num = i * 2

        while (num <= b) {
            arr[num] = false
            num += i
        }
    }

    for (num in a..b) {
        if(!arr[num]) continue
        if (num.toString() == num.toString().reversed()) sb.appendLine(num)
    }

    sb.appendLine(-1)

    print(sb)
}