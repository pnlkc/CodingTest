fun main() {
    val sb = StringBuilder()
    val N = readln().toInt()

    for (t in 1..N) {
        val list = readln().split(" ").map { it.toInt() }
        val idx = list.lastIndex
        var max = 0

        for (i in 0 until idx) {
            for (j in i + 1..idx) {
                max = maxOf(max, gcd(list[i], list[j]))
            }
        }

        sb.appendLine(max)
    }

    print(sb)
}


fun gcd(a: Int, b:Int): Int = if (a % b == 0) b else gcd(b, a % b)