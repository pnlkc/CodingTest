fun main() {
    val input = readln()
    var result = true
    for (i in 0.. input.lastIndex / 2) {
        if (input[i] != input[input.lastIndex - i]) {
            result = false
            break
        }
    }
    println(if (result) 1 else 0)
}