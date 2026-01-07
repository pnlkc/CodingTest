fun main() {
    var n = readln().toInt()
    var result = 0

    for (i in 18 downTo 10 step 2) {
        result += (n / i) * 2
        n %= i
    }

    for (i in 9 downTo 1) {
        result += n / i
        n %= i
    }

    println(result)
}