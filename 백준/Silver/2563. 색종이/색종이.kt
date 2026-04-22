fun main() {
    val num = readln().toInt()
    var answer = 0
    val array = Array(100) { BooleanArray(100) { true } }

    repeat(num) {
        val (y, x) = readln().split(" ").map { it.toInt() - 1 }

        for (i in y..y + 9) {
            for (j in x..x + 9) {
                if (array[i][j]) {
                    answer++
                    array[i][j] = false
                }
            }
        }
    }

    println(answer)
}