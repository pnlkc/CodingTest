fun main() {
    val a = readln().toInt()
    val t = readln().toInt()
    val type = readln().toInt()
    var num = -1
    var turn = 1
    val arr = intArrayOf(0, 0)
    val addZero: () -> Unit = {
        arr[0]++
        num = (num + 1) % a
    }
    val addOne: () -> Unit = {
        arr[1]++
        num = (num + 1) % a
    }
    val check: () -> Boolean = {
        if (arr[type] == t) {
            println(num)
            true
        } else {
            false
        }
    }

    while (true) {
        addZero()
        if (check()) return

        addOne()
        if (check()) return

        addZero()
        if (check()) return

        addOne()
        if (check()) return

        repeat (turn + 1) {
            addZero()
            if (check()) return
        }

        repeat (turn + 1) {
            addOne()
            if (check()) return
        }

        turn++
    }
}