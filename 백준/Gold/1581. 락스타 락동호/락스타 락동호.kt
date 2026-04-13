fun main() {
    val (ff, fs, sf, ss) = readln().split(" ").map { it.toInt() }
    val result = when {
        ff == 0 && fs == 0 -> ss + minOf(1, sf)
        fs == 0 -> ff
        else -> ff + minOf(fs - 1, sf) * 2 + 1 + ss + if (fs - 1 < sf) 1 else 0
    }

    println(result)
}