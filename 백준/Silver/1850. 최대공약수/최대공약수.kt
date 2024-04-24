fun main() {
    val (A, B) = readln().split(" ").map { it.toLong() }
    val gcd = gcd(A, B)
    var sb = StringBuilder()

    for (i in 1..gcd) {
        sb.append("1")
    }

    println(sb)
}

fun gcd(a: Long, b: Long): Long = if (b == 0L) a else gcd(b, a % b)