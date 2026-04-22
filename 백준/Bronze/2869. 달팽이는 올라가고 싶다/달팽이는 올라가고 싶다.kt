fun main() {
    val (up, down, target) = readln().split(" ").map { it.toInt() }
    println((target - up) / (up - down) + if ((target - up) % (up - down) == 0) 1 else 2)
}