import kotlin.math.abs

fun main() {
    val N = readln().toInt()
    var (s, e) = readln().split(" ").map { it.toInt() }
    var result = abs(e - s)

    for (i in 2..N) {
        val (ns, ne) = readln().split(" ").map { it.toInt() }

        if (s <= ns && e >= ne) continue

        if (e >= ns) {
            result += abs(ne - e)
            e = ne
        } else {
            result += abs(ne - ns)
            e = ne
        }
    }

    println(result)
}