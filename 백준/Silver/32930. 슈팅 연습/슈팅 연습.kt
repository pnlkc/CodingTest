data class Pos(val x: Int, val y: Int)

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val list = mutableListOf<Pos>()
    var cPos = Pos(0, 0)
    var result = 0
    val sort: () -> Unit = {
        list.sortByDescending {
            val diffX = cPos.x - it.x
            val diffY = cPos.y - it.y

            diffX * diffX + diffY * diffY
        }
    }
    val dist: () -> Int = {
        val diffX = cPos.x - list.first().x
        val diffY = cPos.y - list.first().y

        diffX * diffX + diffY * diffY
    }

    repeat(n) {
        val (x, y) = readln().split(" ").map { it.toInt() }

        list.add(Pos(x, y))
    }

    repeat(m) {
        val (x, y) = readln().split(" ").map { it.toInt() }

        sort()
        result += dist()
        cPos = list.first()
        list.removeAt(0)
        list.add(Pos(x, y))
    }

    println(result)
}