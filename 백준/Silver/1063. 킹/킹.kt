data class Pos(val x: Int, val y: Int)

fun main() {
    val (k, s, N) = readln().split(" ")
    var king = Pos(k[0] - 'A' + 1, k[1].digitToInt())
    var stone = Pos(s[0] - 'A' + 1, s[1].digitToInt())
    val map = mutableMapOf(
        "R" to intArrayOf(1, 0),
        "L" to intArrayOf(-1, 0),
        "B" to intArrayOf(0, -1),
        "T" to intArrayOf(0, 1),
        "RT" to intArrayOf(1, 1),
        "LT" to intArrayOf(-1, 1),
        "RB" to intArrayOf(1, -1),
        "LB" to intArrayOf(-1, -1),
    )

    for (n in 1..N.toInt()) {
        val command = readln()
        val (dx, dy) = map[command]!!
        val nkx = king.x + dx
        val nky = king.y + dy

        if (nkx < 1 || nky < 1 || nkx > 8 || nky > 8) continue

        if (stone.x == nkx && stone.y == nky) {
            val nsx = stone.x + dx
            val nsy = stone.y + dy

            if (nsx < 1 || nsy < 1 || nsx > 8 || nsy > 8) continue

            stone = Pos(nsx, nsy)
        }

        king = Pos(nkx, nky)
    }

    println("${'A' + king.x - 1}${king.y}")
    println("${'A' + stone.x - 1}${stone.y}")
}