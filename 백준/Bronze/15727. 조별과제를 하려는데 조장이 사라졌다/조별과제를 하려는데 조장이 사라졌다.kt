fun main() {
    val l = readln().toInt()
    println(l / 5 + if (l % 5 != 0) 1 else 0)
}