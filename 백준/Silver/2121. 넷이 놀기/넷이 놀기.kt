data class Pos(val x: Int, val y: Int)

fun main() {
    val N = readln().toInt()
    val (A, B) = readln().split(" ").map { it.toInt() }
    val set = mutableSetOf<Pos>()
    var cnt = 0

    for (i in 1..N) {
        val (x, y) = readln().split(" ").map { it.toInt() }

        set.add(Pos(x, y))
    }

    for (key in set) {
        if (set.contains(Pos(key.x + A, key.y)) && set.contains(Pos(key.x, key.y + B)) && set.contains(Pos(key.x + A, key.y + B))) {
            cnt++
        }
    }

    println(cnt)
}