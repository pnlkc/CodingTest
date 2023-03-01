fun main() {
    val string = readln().lowercase()
    val list = string.toCharArray().distinct()
        .map { c -> string.count { it == c } to c }
        .sortedByDescending { it.first }
    println(if (list.count { it.first == list.first().first } > 1) '?' else list[0].second.uppercase())
}
