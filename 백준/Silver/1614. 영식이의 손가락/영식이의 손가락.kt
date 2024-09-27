fun main() {
    val N = readln().toLong()
    val cnt = readln().toLong()
    var result = 0L

    if (cnt == 0L) {
        println(N - 1)
        return
    }

    if (cnt == 1L) {
        if (N != 5L) {
            println(9 - N)
        } else {
            println(12)
        }
        return
    }

    if (N in 2..4) {
        result = 5
        result += (cnt - 1) * 4

        if (cnt % 2 == 0L) {
            result += N - 2
        } else {
            result += 4- N
        }
    } else if (N == 1L) {
        result = 5
        result += (cnt - 1) * 8 + 3
    } else {
        result = 5
        result += (cnt - 1) * 8 + 7
    }

    println(result)
}