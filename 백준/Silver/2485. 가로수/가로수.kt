fun main() {
    val tcNum = readln().toInt()
    val list = mutableListOf<Int>()
    repeat(tcNum) {
        list.add(readln().toInt())
    }

    val gapList = mutableListOf<Int>()

    for (i in 0 until list.lastIndex) {
        gapList.add(list[i + 1] - list[i])
    }
    
    var gcd = gapList[0]
    gapList.forEach { gcd = gcd(gcd, it) }

    println(gapList.sumOf { it / gcd } - gapList.size)
}

fun gcd(a: Int, b: Int): Int = if (b != 0) gcd(b, a % b) else a