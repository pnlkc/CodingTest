fun main() {
    val n = readln().toInt()
    val t = 48 * 60
    var a = 0
    var aScore = 0
    var b = 0
    var bScore = 0

    for (i in 0 until n) {
        val (num, time) = readln().split(" ")
        val (m, s) = time.split(":").map { it.toInt() }
        val left = t - (m * 60 + s)

        if (num == "1") {
            if (aScore == bScore) a += left
            if (aScore + 1 == bScore) b -= left
            aScore++
        } else {
            if (aScore == bScore) b += left
            if (bScore + 1 == aScore) a-= left
            bScore++
        }
    }

    println("${format(a)}\n${format(b)}")
}

fun format(num: Int) = "${String.format("%02d", num / 60)}:${String.format("%02d", num % 60)}"