fun main() {
    var answer = IntArray(3) { 0 }

    for (i in 0..8) {
        val input = readln().split(" ").map { it.toInt() }
        for (j in 0..8) {
            if (input[j] > answer[0]) {
                answer = intArrayOf(input[j], i, j)
            }
        }
    }
    
    println(answer[0])
    println("${answer[1] + 1} ${answer[2] + 1}")
}