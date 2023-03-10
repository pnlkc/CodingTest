fun main() {
    val input = readln().toInt()
    var answer = 1
    
    for (i in 1..input) {
        answer *= i
    }
    
    println(answer)
}