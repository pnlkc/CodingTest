fun main() {
    val (n, m) = readln().split(' ').map(String::toBigInteger)
    println("${n / m}\n${n % m}")
}