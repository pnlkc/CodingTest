fun main() {
    val n = readln().toInt()
    val map = mutableMapOf<String, Int>()

    repeat(n) {
        val str = readln().toCharArray()

        str.sort()

        val key = str.joinToString("")

        map[key] = map.getOrDefault(key, 0) + 1
    }

    println(map.size)
}