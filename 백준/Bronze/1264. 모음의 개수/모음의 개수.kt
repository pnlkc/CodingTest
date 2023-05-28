fun main() {
    val arr = arrayOf('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')
    while (true) {
        val input = readln()
        if (input == "#") break

        println(input.count { arr.contains(it) })
    }
}