fun main() {
    val N = readln().toInt()
    val str = readln().toCharArray().sorted()

    println(str.joinToString("").repeat(N))
}