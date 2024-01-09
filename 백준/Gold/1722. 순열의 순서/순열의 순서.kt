import java.util.StringTokenizer

var N = 0
val arr = LongArray(21) { 0 }
var used = booleanArrayOf()
var result = intArrayOf()
var r = 1L

fun main() {
    N = readln().toInt()
    val st = StringTokenizer(readln())
    used = BooleanArray(N + 1)
    result = IntArray(N)

    arr[1] = 1

    for (i in 2..20) {
        arr[i] = arr[i - 1] * i
    }


    used[0] = true

    if (st.nextToken().toInt() == 1) {
        val target = st.nextToken().toLong()

        calc(0, target - 1)

        println(result.joinToString(" "))
    } else {
        val target = IntArray(N + 1)

        for (i in 1..N) {
            target[i] = st.nextToken().toInt()
        }

        calc(1, target)

        println(r)
    }
}

fun calc(idx: Int, target: Long) {
    if (idx >= N) return

    var a = if (N - 1 - idx == 0) 0 else target / arr[N - 1 - idx]
    val b =  if (N - 1 - idx == 0) 0 else target % arr[N - 1 - idx]

    var c = 0
    for (i in 1..N) {
        if (!used[i]) {
            c = i
            break
        }
    }

    while (a > 0) {
        if (!used[++c]) a--
    }

    result[idx] = c
    used[c] = true

    calc(idx + 1, b)
}

fun calc(idx: Int, target: IntArray) {
    if (idx > N) return

    var a = 0

    for (i in 1..N) {
        if (!used[i]) {
            if (target[idx] == i) {
                used[i] = true
                break
            }
            a++
        }
    }

    r += a * arr[N - idx]

    calc(idx + 1, target)
}