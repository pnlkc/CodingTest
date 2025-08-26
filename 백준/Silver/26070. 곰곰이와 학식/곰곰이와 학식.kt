fun main() {
    var (A, B, C) = readln().split(" ").map { it.toInt() }
    var (X, Y, Z) = readln().split(" ").map { it.toInt() }
    var result = 0L
    var maxA = minOf(A, X)
    var maxB = minOf(B, Y)
    var maxC = minOf(C, Z)

    result += maxA
    A -= maxA
    X -= maxA
    result += maxB
    B -= maxB
    Y -= maxB
    result += maxC
    C -= maxC
    Z -= maxC

    if (A == 0) {
        val num = X / 3

        Y += num
        X -= num * 3
        maxB = minOf(B, Y)
        result += maxB
        B -= maxB
        Y -= maxB
    }

    if (B == 0) {
        val num = Y / 3

        Z += num
        Y -= num * 3
        maxC = minOf(C, Z)
        result += maxC
        C -= maxC
        Z -= maxC
    }

    if (C == 0) {
        val num = Z / 3

        X += num
        Z -= num * 3
        maxA = minOf(A, X)
        result += maxA
        A -= maxA
        X -= maxA
    }

    if (A == 0) {
        val num = X / 3

        Y += num
        X -= num * 3
        maxB = minOf(B, Y)
        result += maxB
        B -= maxB
        Y -= maxB
    }

    println(result)
}