fun main() {
    val map = mutableMapOf<String, Boolean>()
    var count = 0

    repeat(readln().toInt()) {
        val input = readln()
        if (input == "ENTER") {
            map.clear()
        } else if (map[input] == null) {
            map[input] = false
            count++
        }
    }

    println(count)
}