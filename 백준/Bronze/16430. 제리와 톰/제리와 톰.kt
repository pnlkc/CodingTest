fun main() {
    var (a, b) = readln().split(" ").map(String::toInt)
    a = b - a
    p@while (true) {
        for (i in 2..minOf(a, b)) {
            if (a % i == 0 && b % i == 0) {
                a /= i
                b /= i
                continue@p
            }
        }
        break
    }
    println("$a $b")
}