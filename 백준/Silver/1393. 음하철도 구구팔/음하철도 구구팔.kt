import kotlin.math.abs

fun main() {
    val (xs, ys) = readln().split(" ").map { it.toInt() }
    val (xe, ye, dx, dy) = readln().split(" ").map { it.toInt() }
    val gcd = gcd(dx, dy)
    val x = if (gcd == 0) 0 else dx / abs(gcd)
    val y = if (gcd == 0) 0 else dy / abs(gcd)
    var min = (xs - xe) * (xs - xe) + (ys - ye) * (ys - ye)
    var answer = "$xe $ye"
    var cx = xe
    var cy = ye

    while (true) {
        cx += x
        cy += y

        val dist = (cx - xs) * (cx - xs) + (cy - ys) * (cy - ys)

        if (dist >= min) break

        min = dist
        answer = "$cx $cy"
    }

    println(answer)
}

fun gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)