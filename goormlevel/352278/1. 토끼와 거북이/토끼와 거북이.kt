fun main() {
    val (a, b, c) = readLine()!!.split(" ").map { it.toInt() }
    var result = (b - a) / c

    if ((b - a) % c != 0) result++

    println(result)
}