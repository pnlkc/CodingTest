fun main() {
    val (n, m, k) = readln().split(' ').map(String::toInt)
    println("${k / m} ${k % m}")
}