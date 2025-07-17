fun main() {
    val N = readln().toLong()
    var num = N
    var result = 0

    while ((num * 2).toString().length == N.toString().length) {
        num *= 2
        result++
    }

    println(result)
}