import java.math.*

fun main() {
    val sb = StringBuilder()
    
    repeat(3) {
        val n = readln().toInt()
        var num = BigInteger.ZERO
        
        repeat(n) {
            num = num + readln().toBigInteger()
        }
        
        when {
            num == BigInteger.ZERO -> sb.appendLine("0")
            num > BigInteger.ZERO -> sb.appendLine("+")
            num < BigInteger.ZERO -> sb.appendLine("-")
        }
    }
    
    println(sb)
}