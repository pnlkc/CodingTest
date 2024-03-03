fun main() {
    var (N, kim, im) = readln().split(" ").map { it.toInt() }
    var r = 1

    while (minOf(kim, im) % 2 == 0 || minOf(kim, im) + 1 != maxOf(kim, im)) {
        if (kim % 2 != 0) kim++
        kim /= 2

        if (im % 2 != 0) im++
        im /= 2

        r++
    }

    println(r)
}