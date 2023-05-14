fun main() {
    val map = ('a'..'z').map { it to 0 }.toMap().toMutableMap()
    val sb = StringBuilder()
    
    repeat(readln().toInt()) {
        val s = readln()
        map[s[0]] = map[s[0]]!! + 1
    }
    
    map.forEach { c, i -> if (i >= 5) sb.append(c) }
    println (sb.ifEmpty { "PREDAJA" })
}