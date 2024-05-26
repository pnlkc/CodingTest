fun main() {
    val (A, B, N) = readln().split(" ").map { it.toInt() }
    var newA = A
    
    for (i in 1..N) {
        newA %= B
        newA *= 10
    }

    println(newA / B)
}