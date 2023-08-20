import kotlin.math.abs
import kotlin.math.acos
import kotlin.math.sqrt


fun main() {
    while (true) {
        val input = readln()
        if (input == "-1") break

        val arr = input.split(" ").map(String::toDouble)
        val lArr = doubleArrayOf(
            calcDist(arr[0], arr[1], arr[2], arr[3]),
            calcDist(arr[0], arr[1], arr[4], arr[5]),
            calcDist(arr[2], arr[3], arr[4], arr[5])
        ).sorted()

        val angles = angleBetweenPoints(arr)

        if (checkLine(arr) || lArr[2] >= lArr[0] + lArr[1]) {
            println("Not a Triangle")
        } else if (abs(lArr[0] - lArr[1]) < 0.01 && abs(lArr[0] - lArr[2])  < 0.01 && abs(lArr[1] - lArr[2])  < 0.01) {
            if (angles[0] > 92 || angles[1] > 92 || angles[2] > 92) {
                println("Equilateral Obtuse")
            } else if (angles[0] < 88 && angles[1] < 88 && angles[2] < 88) {
                println("Equilateral Acute")
            } else {
                println("Equilateral Right")
            }
        } else if (abs(lArr[0] - lArr[1]) < 0.01 || abs(lArr[0] - lArr[2])  < 0.01 || abs(lArr[1] - lArr[2])  < 0.01) {
            if (angles[0] > 92 || angles[1] > 92 || angles[2] > 92) {
                println("Isosceles Obtuse")
            } else if (angles[0] < 88 && angles[1] < 88 && angles[2] < 88) {
                println("Isosceles Acute")
            } else {
                println("Isosceles Right")
            }
        } else {
            if (angles[0] > 92 || angles[1] > 92 || angles[2] > 92) {
                println("Scalene Obtuse")
            } else if (angles[0] < 88 && angles[1] < 88 && angles[2] < 88) {
                println("Scalene Acute")
            } else {
                println("Scalene Right")
            }
        }
    }
}

fun checkLine(arr: List<Double>): Boolean {
    val t1 = arr[3] - arr[1]
    val b1 = arr[2] - arr[0]
    val t2 = arr[5] - arr[3]
    val b2 = arr[4] - arr[2]
    return t1 * b2 == b1 * t2
}

fun calcDist(x1: Double, y1: Double, x2: Double, y2: Double): Double {
    return sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2))
}

fun angleBetweenPoints(arr: List<Double>): List<Double> {
    val a = distanceBetweenPoints(arr[2], arr[3], arr[4], arr[5])
    val b = distanceBetweenPoints(arr[0], arr[1], arr[4], arr[5])
    val c = distanceBetweenPoints(arr[0], arr[1], arr[2], arr[3])

    val alpha = Math.toDegrees(acos((b * b + c * c - a * a) / (2 * b * c)))
    val beta = Math.toDegrees(acos((a * a + c * c - b * b) / (2 * a * c)))
    val gamma = 180.0 - alpha - beta

    return listOf(alpha, beta, gamma)
}

fun distanceBetweenPoints(x1: Double, y1: Double, x2: Double, y2: Double): Double {
    val dx = x2 - x1
    val dy = y2 - y1
    return sqrt(dx * dx + dy * dy)
}