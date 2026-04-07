fun main() {
    val n = readln().toInt()
    val map = mutableMapOf(1 to 1, 2 to 2, 3 to 3)

    repeat(n) {
        val (x, y) = readln().split(" ").map { it.toInt() }
        val temp = map[x]!!

        map[x] = map[y]!!
        map[y] = temp
    }

    for (i in 1..3) {
        if (map[i] == 1) {
            println(i)
            return
        }
    }
}