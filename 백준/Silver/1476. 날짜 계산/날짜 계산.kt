fun main() {
    var (E, S, M) = readln().split(" ").map { it.toInt() }
    var num = 1

    if (E == 15) E = 0
    if (S == 28) S = 0
    if (M == 19) M = 0

    while (true) {
        if ((num % 15 == E && num % 28 == S && num % 19 == M)) {
            println(num)
            break
        }

        num++
    }
}