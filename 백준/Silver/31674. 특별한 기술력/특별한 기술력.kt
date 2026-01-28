fun main() {
    val n = readln().toInt()
    val hArr = readln().split(" ").map { it.toInt() }.toTypedArray().sortedArrayDescending()
    val NUM = 1_000_000_007
    var result = 0L

    for (i in 0 until n) {
        result = (result + result + hArr[i]) % NUM
    }

    println(result)
}