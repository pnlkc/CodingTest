fun main() {
    val N = readln().toInt()
    val arr = readln().split(" ").map { it.toLong() }
    var gcd = arr[0]
    var result = arr[0]

    for (i in 0 until N - 2) {
        gcd = gcd(result, arr[i])
        result = result / gcd * arr[i]
    }

    println(result)
}

fun gcd(a: Long, b: Long): Long = if (b == 0L) a else gcd(b, a % b)