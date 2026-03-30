fun main() {
    val aL = readln().split(" ").map { it.toInt() }.toIntArray()
    val bL = readln().split(" ").map { it.toInt() }.toIntArray()
    val acL = readln().split(" ").map { it.toInt() }.toIntArray()
    val bcL = readln().split(" ").map { it.toInt() }.toIntArray()

    val a1 = calc(aL)
    val b1 = calc(bL)

    for (i in 0..4) {
        aL[i] += bcL[i] - acL[i]
        bL[i] += acL[i] - bcL[i]
    }

    val a2 = calc(aL)
    val b2 = calc(bL)

    println(if (a1 == a2) "0" else if (a1 > a2) "-" else "+")
    println(if (b1 == b2) "0" else if (b1 > b2) "-" else "+")
}

fun calc(list: IntArray): Long {
    val a = list[0].toLong()
    val b = 100L + list[1]
    val c = 100L * (100 - minOf(list[2], 100)) + minOf(list[2], 100) * list[3]
    val d = 100L + list[4]
    
    return a * b * c * d
}