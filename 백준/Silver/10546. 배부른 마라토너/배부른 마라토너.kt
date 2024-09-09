fun main() {
    val N = readln().toInt()
    val map = mutableMapOf<String, Int>()

    for (i in 1..N) {
        val name = readln()
        if (map[name] == null) map[name] = 1 else map[name] = map[name]!! + 1
    }

    for (i in 1 until N) {
        val name = readln()
        map[name] = map[name]!! - 1
    }

    for ((n, v) in map) {
        if (v != 0) {
            println(n)
            return
        }
    }
}