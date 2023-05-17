fun main() {
    val input = readln().split(' ').map(String::toInt).toIntArray()
    var t = 0
    var c = input[1]

    while (input[0] > 0) {
        if (c + input[3] <= input[2]) {
            c += input[3]
            input[0]--
            t++
        } else {
            if (c == input[1]) return println(-1)
            c = maxOf(input[1], c - input[4])
            t++
        }
    }

    println(t)
}