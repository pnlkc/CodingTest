fun main() {
    while(true) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        if (a == 0 && b == 0) break
        
        when {
            a % b == 0 -> println("multiple")
            b % a == 0 -> println("factor")
            else -> println("neither")
        }
    }
}