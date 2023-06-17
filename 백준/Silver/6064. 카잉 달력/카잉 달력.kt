fun main() {
    val sb = StringBuilder()

    repeat(readln().toInt()) {
        val (m, n, x, y) = readln().split(' ').map(String::toInt)
        val lcm = m * n / gcd(m, n)
        var s= x
        var r = false

        while (s <= lcm) {
            if (s % n == if (n == y) 0 else y) {
                r = true
                break
            }
            s += m
        }

        sb.appendLine(if (r) s else -1)
    }

    println(sb.toString())
}

fun gcd(a: Int, b:Int): Int = if(b != 0) gcd(b, a % b) else a