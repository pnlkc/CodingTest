fun main() {
    val (n, c) = readln().split(" ").map { it.toInt() }
    var xSize = n
    var ySize = n

    for (i in 0 until c) {
        val (x, y) = readln().split(" ").map { it.toInt() }
        val a = x * xSize
        val b = y * ySize

        when {
            a >= b -> ySize = x
            a < b -> xSize = y
        }
    }

    println(xSize * ySize)
}