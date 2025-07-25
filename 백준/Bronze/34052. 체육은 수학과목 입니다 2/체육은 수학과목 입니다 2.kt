fun main() {
    var sum = 0

    repeat(4) {
        sum += readln().toInt()
    }

    println(if (sum > 1500) "No" else "Yes")
}