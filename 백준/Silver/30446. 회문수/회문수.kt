fun main() {
    val N = readln()
    var result = 0L

    for (i in 1 until N.length) {
        var temp = i / 2 + if (i % 2 == 0) 0 else 1
        var add = 1

        add *= 9
        temp--

        while (temp > 0) {
            temp--
            add *= 10
        }

        result += add
    }

    var start = 1L
    val times = N.length / 2 + if (N.length % 2 == 0) 0 else 1
    val isOdd = N.length % 2 != 0

    repeat(times - 1) {
        start *= 10
    }

    while (true) {
        val num = "$start${start.toString().reversed().let { 
            if (isOdd) it.drop(1)
            else it
        }}".toLong()

        if (num > N.toLong()) break
        result++
        start++
    }

    println(result)
}