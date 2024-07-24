fun main() {
    val str = readln()
    val N = readln().toInt()
    val arr = Array(N) { "" }

    for (i in 0 until N) {
        val input = readln()

        arr[i] = input
    }

    for (i in 0 until 26) {
        val newStr = str.map {
            var temp = it.code + i
            if (temp >= 123) temp -= 26
            temp.toChar()
        }.joinToString("")

        for (target in arr) {
            if (newStr.contains(target)) {
                println(newStr)
                return
            }
        }
    }
}