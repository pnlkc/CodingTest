fun main() {
    val N = readln().toInt()
    val map = mutableMapOf<String, Int>()
    var max = 0
    var result = ""

    for (i in 1..N) {
        val input = readln()

        if (map[input] == null) {
            map[input] = 1
        } else {
            map[input] = map[input]!! + 1
        }
    }

    map.keys.sorted().forEach {
        if (map[it]!! > max) {
            max = map[it]!!
            result = it
        }
    }

    println(result)
}