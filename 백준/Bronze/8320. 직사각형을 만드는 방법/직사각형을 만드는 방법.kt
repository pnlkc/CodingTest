import java.math.*

fun main() {
    val n = readln().toInt()
    var count = 0
    
    for (k in 1..n) {
        val sqrt = Math.sqrt(k.toDouble()).toInt()
        for (i in 1..sqrt) {
            for (j in sqrt..k) {
                if (i * j == k) count++ 
                else if (i * j > k) break
            }
        }
    }
    
    println(count)
}