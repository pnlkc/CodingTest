fun main() {
    val map = mutableMapOf("ChongChong" to true)

    repeat(readln().toInt()) {
        val (p1, p2) = readln().split(" ")
        if (map[p1] == true && map[p2] != true) {
            map[p2] = true
        } else if (map[p2] == true && map[p1] != true) {
            map[p1] = true
        }
    }

    println(map.size)
}