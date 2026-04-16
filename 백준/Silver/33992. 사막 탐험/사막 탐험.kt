import java.util.StringTokenizer
import kotlin.math.sqrt

fun main() {
    val st = StringTokenizer(readln())
    val ax = st.nextToken().toDouble()
    val ay = st.nextToken().toDouble()
    val bx = st.nextToken().toDouble()
    val by = st.nextToken().toDouble()
    val px = st.nextToken().toDouble()
    val py = st.nextToken().toDouble()
    val r = st.nextToken().toDouble()

    println(
        minOf(
            calc(ax, ay, bx, by),
            maxOf(0.0, calc(ax, ay, px, py) - r) + maxOf(0.0, calc(bx, by, px, py) - r)
        )
    )
}

fun calc(ax: Double, ay: Double, bx: Double, by: Double): Double {
    return sqrt((ax - bx) * (ax - bx) + (ay - by) * (ay - by))
}