fun main() {
    val (N, M) = readln().split(" ").map { it.toInt() }
    val (sx, sy) = readln().split(" ").map { it.toInt() }
    val (ex, ey) = readln().split(" ").map { it.toInt() }
    var result = false

    when {
        sx % 2 == 0 && sy % 2 == 0 -> {
            if (ex % 2 == 0 && ey % 2 == 0) result = true
            if (ex % 2 != 0 && ey % 2 != 0) result = true
        }
        sx % 2 == 0 && sy % 2 != 0 -> {
            if (ex % 2 == 0 && ey % 2 != 0) result = true
            if (ex % 2 != 0 && ey % 2 == 0) result = true
        }
        sx % 2 != 0 && sy % 2 == 0 -> {
            if (ex % 2 != 0 && ey % 2 == 0) result = true
            if (ex % 2 == 0 && ey % 2 != 0) result = true
        }
        else -> {
            if (ex % 2 != 0 && ey % 2 != 0) result = true
            if (ex % 2 == 0 && ey % 2 == 0) result = true
        }
    }

    if (N == 1 || M == 1) if (sx != ex || sy != ey) result = false

    println(if (result) "YES" else "NO")
}