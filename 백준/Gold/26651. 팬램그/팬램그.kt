import java.io.BufferedWriter
import java.io.OutputStreamWriter
import kotlin.math.sqrt

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    var x = readln().toInt()

    if (x == 0) {
        println("GBSISTHEBEST")
        return
    }
    
    while (x > 1) {
        val sqrt = sqrt(x.toDouble()).toInt()

        repeat(sqrt) {
            bw.write("A")
        }

        for (c in 'B'..'Y') {
            bw.write("$c")
        }

        repeat(sqrt) {
            bw.write("Z")
        }

        x -= sqrt * sqrt
    }

    if (x != 0) {
        for (c in 'A'..'Z') {
            bw.write("$c")
        }
    }

    bw.flush()
    bw.close()
}