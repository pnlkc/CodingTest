fun main() {
    val N = readln().toInt()
    val arr = BooleanArray(1000) { true }
    val range = 100..999

    for (i in 0..99) {
        arr[i] = false
    }

    range.forEach { i ->
        val one = i / 100
        val two = i % 100 / 10
        val three = i % 10

        if (one == two || two == three || one == three) {
            arr[i] = false
        }

        if (one == 0 || two == 0 || three == 0) {
            arr[i] = false
        }
    }

    for (n in 1..N) {
        val (input, s, b) = readln().split(" ").map { it.toInt() }
        val one = input / 100
        val two = input % 100 / 10
        val three = input % 10

        when (s) {
            0 -> {
                range.forEach { i ->
                    if (i / 100 == one || i % 100 / 10 == two || i % 10 == three) {
                        arr[i] = false
                    }
                }
            }

            1 -> {
                range.forEach { i ->
                    if (i / 100 != one && i % 100 / 10 != two && i % 10 != three) {
                        arr[i] = false
                    }

                    if ((i / 100 == one && i % 100 / 10 == two) || (i / 100 == one && i % 10 == three) || (i % 100 / 10 == two && i % 10 == three)) {
                        arr[i] = false
                    }
                }
            }

            2 -> {
                range.forEach { i ->
                    if ((i / 100 != one && i % 100 / 10 != two) && (i / 100 != one && i % 10 != three) && (i % 100 / 10 != two && i % 10 != three)) {
                        arr[i] = false
                    }
                }
            }

            3 -> {
                println(1)
                return
            }
        }

        range.forEach { i ->
            if (arr[i]) {
                val list = setOf(i / 100, i % 100 / 10, i % 10)
                var cnt = 0
                if (list.contains(one)) cnt++
                if (list.contains(two)) cnt++
                if (list.contains(three)) cnt++

                if (cnt != (s + b)) {
                    arr[i] = false
                }
            }
        }
    }

    println(arr.count { it })
}