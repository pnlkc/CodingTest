fun main() {
    println(readln().map { if (it.isLowerCase()) it.uppercase() else it.lowercase()}.joinToString(""))
}