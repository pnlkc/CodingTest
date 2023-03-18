fun main() {
    val n = readln().toInt()
    println("${fib(n)} ${fibonacci(n)}")
}

fun fib(n: Int): Int = if (n == 1 || n == 2) 1 else fib(n - 1) + fib(n - 2)

fun fibonacci(n: Int): Int {
    var result = 0
    val array = Array(n) { 1 }
    for (i in 2 until n) {
        array[i] = array[i - 1] + array[i - 2]
        result++
    }
    return result
}