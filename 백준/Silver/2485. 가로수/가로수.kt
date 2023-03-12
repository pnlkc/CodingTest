fun main() {
    val tcNum = readln().toInt()
    val gapList = mutableListOf<Long>()
    var previousNum = readln().toLong()

    repeat(tcNum - 1) {
        val input = readln().toLong()
        gapList.add(input - previousNum)
        previousNum = input
    }

    var gcd = gapList[0]
    gapList.forEach { gcd = gcd(gcd, it) }

    println(gapList.sum() / gcd - gapList.size)
}

fun gcd(a: Long, b: Long): Long = if (b != 0L) gcd(b, a % b) else a