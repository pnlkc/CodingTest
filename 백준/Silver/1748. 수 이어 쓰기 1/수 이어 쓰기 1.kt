fun main() {
    val N = readln().toInt()
    var result = 0

    var num = 1
    repeat(N.toString().length - 1) {
        num *= 10
    }

    result += (N - num + 1) * N.toString().length

    while (num > 1) {
        val temp = num / 10

        result += (num - temp) * temp.toString().length
        num = temp
    }

    println(result)
}