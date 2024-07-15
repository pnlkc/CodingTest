fun main() {
    val sb = StringBuilder()
    var (na, nb) = readln().split(" ").map { it.toInt() }
    val aL = readln().split(" ").map { it.toInt() }.sorted()
    val bL = readln().split(" ").map { it.toInt() }
    val map = mutableMapOf<Int, Boolean>()

    aL.forEach { map[it] = true }
    bL.forEach {
        if (map[it] != null) {
            map[it] = false
            na--
        }
    }

    println(na)
    if (na > 0) {
        aL.forEach { if (map[it] == true) sb.append("$it ") }
        println(sb.trim())
    }
}