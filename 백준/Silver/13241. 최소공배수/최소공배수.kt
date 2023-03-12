fun main() {
    val input = readln().split(" ").map { it.toLong() }
    var a = input[0]
    var b = input[1]
    while (a != b) {
        if (a > b) b += input[1] else a += input[0]
    }
    println(a)
}