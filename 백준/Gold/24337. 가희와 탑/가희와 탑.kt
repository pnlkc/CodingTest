fun main() {
    val (N, a, b) = readln().split(" ").map { it.toInt() }
    val list = IntArray(a + b - 1) { 1 }

    if (a + b - 1 > N) {
        println(-1)
        return
    }

    if (a > b) {
        bCalc(list, a, b)
        aCalc(list, a)
    } else {
        aCalc(list, a)
        bCalc(list, a, b)
    }

    var sb = StringBuilder()

    if (list.size < N) {
        sb.append("${list[0]} ")

        repeat(N - list.size) {
            sb.append("1 ")
        }

        for (i in 1 until list.size) {
            sb.append("${list[i]}")
            if (i != list.lastIndex) sb.append(" ")
        }

        println(sb)
    } else {
        println(list.joinToString(" "))
    }
}

fun aCalc(arr: IntArray, a: Int) = (0 until a).forEach { arr[it] = it + 1 }

fun bCalc(arr: IntArray, a: Int, b: Int) = (a + b - 2 downTo a - 1).forEach { arr[it] = a + b - 1 - it }