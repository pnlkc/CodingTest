fun main() {
    val map = mutableMapOf<String, Boolean>()
    val s = StringBuilder()

    repeat(readln().toInt()) {
        val (name, status) = readln().split(" ")
        map[name] = status == "enter"
    }

    map.filterValues { it }.keys.sortedDescending().forEach {
        s.append(it).append("\n")
    }

    println(s.toString())
}