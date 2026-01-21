fun main() {
    val (s, e, q) = readln().split(" ")
    val map = mutableMapOf<String, Boolean>()

    while (true) {
        val input = readlnOrNull() ?: break
        val (time, name) = input.split(" ")

        if (time <= s) {
            map[name] = false
        }

        if (time in e..q) {
            if (map[name] == null) continue
            map[name] = true
        }
    }

    println(map.values.count { it })
}