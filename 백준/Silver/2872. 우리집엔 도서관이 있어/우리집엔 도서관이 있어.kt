fun main() {
    val n = readln().toInt()
    var max = 0
    var result = 0

    for (i in 0 until n) {
        val num = readln().toInt()

        if (num > max) max = num else result = maxOf(result, num)
    }

    println(result)
}