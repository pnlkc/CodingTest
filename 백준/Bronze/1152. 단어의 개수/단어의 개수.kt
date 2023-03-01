fun main() {
    val string = readln().trim()
    println(if (string.isBlank()) 0 else string.split(" ").size)
}
