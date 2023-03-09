fun main() {
    val (testCaseNum, target) = readln().split(" ").map { it.toInt() }
    val list = readln().split(" ").map { it.toInt() }
    var answer = 0
    
    p@for (i in 0..list.lastIndex - 2) {
        for (j in i + 1 until list.lastIndex) {
            for (k in j + 1..list.lastIndex) {
                val sum = list[i] + list[j] + list[k]
                if (sum in answer + 1..target) answer = sum
                if (answer == target) break@p
            }
        }
    }
    
    println(answer)
}