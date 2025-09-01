fun main() {
    val N = readln().toInt()
    val K = readln().toInt()
    val arr = BooleanArray(K + 1) { true }
    val list = mutableListOf<Int>()
    var cnt = 0

    arr[0] = false
    arr[1] = false

    for (i in 2..K) {
        var num = i * 2

        while (num <= 100_000) {
            if (num > K) break

            arr[num] = false
            num += i
        }
    }

    for (i in 2..K) {
        if (arr[i]) list.add(i)
    }

    for (i in 1..N) {
        var num = i

        p@ while (i != 1) {
            for (pn in list) {
                if (num % pn == 0) {
                    num /= pn
                    continue@p
                }
            }

            break
        }

        if (num == 1) cnt++
    }

    println(cnt)
}