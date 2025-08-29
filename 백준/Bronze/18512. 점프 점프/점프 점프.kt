fun main() {
    var (x, y, p1, p2) = readln().split(" ").map { it.toInt() }

    if (p1 == p2) {
        println(p1)
        return
    }

    while (p1 != p2) {
        if (p1 < p2) {
            p1 += x
        } else {
            p2 += y
        }

        if (p1 > 10_100 || p2 > 10_100) break
    }

    println(if (p1 != p2) -1 else p1)
}