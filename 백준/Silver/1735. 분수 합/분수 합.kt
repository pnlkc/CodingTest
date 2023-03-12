fun main() {
    val input1 = readln().split(" ").map { it.toInt() }
    val input2 = readln().split(" ").map { it.toInt() }
    val top = input1[0] * input2[1] + input1[1] * input2[0]
    val bottom = input1[1] * input2[1]
    val gcd = gcd(top, bottom)

    println("${top / gcd} ${bottom / gcd}")
}

fun gcd(a: Int, b: Int): Int = if (b != 0) gcd(b, a % b) else a