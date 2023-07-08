fun main() {
    val (a, b) = readln().split(' ').map(String::toLong)
    println((a + b) * (a - b))
}