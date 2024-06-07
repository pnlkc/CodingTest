fun main() {
    val N = readln().toInt()
    val map = mutableMapOf<String, Int>()

    for (i in 1..N) {
        val input = readln().split(".")

        if (map[input[1]] == null) {
            map[input[1]] = 1
        } else {
            map[input[1]] = map[input[1]]!! + 1
        }
    }

    map.keys.sorted().forEach {
        println("$it ${map[it]}")
    }
}