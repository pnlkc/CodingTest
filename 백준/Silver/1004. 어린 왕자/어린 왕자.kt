fun main() {
    val tcNum = readln().toInt()
    repeat(tcNum) {
        var result = 0
        val pos = readln().split(" ").map { it.toInt() }
        val num = readln().toInt()
        repeat(num) {
            val input = readln().split(" ").map { it.toInt() }
            val dist1 = distSquare(pos[0], pos[1], input[0], input[1])
            val dist2 = distSquare(pos[2], pos[3], input[0], input[1])
            if (input[2] * input[2] in dist1..dist2 || input[2] * input[2] in dist2..dist1) {
                result++
            }
        }
        println(result)
    }
}

fun distSquare(x1: Int, y1: Int, x2: Int, y2: Int) = (x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1)