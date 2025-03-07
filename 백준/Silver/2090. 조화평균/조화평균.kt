fun main() {
    val N = readln().toInt()
    val list = readln().split(" ").map { it.toInt() }
    var top = 0L
    var bottom = 1L

    for (i in 0 until N) {
        var num = 1L

        for (j in 0 until N) {
            if (i == j) continue

            num *= list[j]
        }

        bottom *= list[i]
        top += num
    }

    val gcd = gcd(top, bottom)

    println("${bottom / gcd}/${top / gcd}")
}

fun gcd(a: Long, b: Long): Long = if (b == 0L) a else gcd(b, a % b)