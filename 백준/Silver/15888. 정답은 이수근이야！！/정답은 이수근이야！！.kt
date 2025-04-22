import kotlin.math.roundToInt
import kotlin.math.sqrt

fun main() {
    val (A, B, C) = readln().split(" ").map { it.toInt() }
    val calcA = B * B - 4 * A * C

    if (calcA <= 0) {
        println("둘다틀렸근")
        return
    }

    val cB = ((-B + sqrt(calcA.toDouble())) / (2 * A)).roundToInt()
    var calcB = cB
    var canB = false
    val cC = ((-B - sqrt(calcA.toDouble())) / (2 * A)).roundToInt()
    var calcC = cC
    var canC = false

    while (calcB > 1) {
        calcB /= 2
        if (calcB == 1) canB = true
    }

    while (calcC > 1) {
        calcC /= 2
        if (calcC == 1) canC = true
    }

    println(
        if ((A * cB * cB + B * cB + C != 0) || (A * cC * cC + B * cC + C != 0)) "둘다틀렸근"
        else if (canB && canC) "이수근"
        else "정수근"
    )
}