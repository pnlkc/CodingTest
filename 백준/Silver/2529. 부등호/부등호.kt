var min = ""
var max = ""
var p1 = intArrayOf()
var p2 = intArrayOf()
var input = listOf<Char>()

fun main() {
    val k = readln().toInt()
    input = readln().split(" ").map { it[0] }
    p1 = IntArray(k + 1)
    p2 = IntArray(k + 1)

    pickMax(0, k)
    pickMin(0, k)

    println(max)
    println(min)
}

fun pickMax(idx: Int, k: Int) {
    if (max.isNotEmpty()) return

    if (idx > k) {
        max = p1.joinToString("")
        return
    }

    p@for (i in 9 downTo  0) {
        for (j in 0 until idx) {
            if (p1[j] == i) continue@p
        }

        if (idx == 0) {
            p1[idx] = i
            pickMax(1, k)
        } else {
            if (input[idx - 1] == '>') {
                if (p1[idx - 1] > i) {
                    p1[idx] = i
                    pickMax(idx + 1, k)
                }
            } else {
                if (p1[idx - 1] < i) {
                    p1[idx] = i
                    pickMax(idx + 1, k)
                }
            }
        }
    }
}

fun pickMin(idx: Int, k: Int) {
    if (min.isNotEmpty()) return

    if (idx > k) {
        min = p2.joinToString("")
        return
    }

    p@for (i in 0..9) {
        for (j in 0 until idx) {
            if (p2[j] == i) continue@p
        }

        if (idx == 0) {
            p2[idx] = i
            pickMin(1, k)
        } else {
            if (input[idx - 1] == '>') {
                if (p2[idx - 1] > i) {
                    p2[idx] = i
                    pickMin(idx + 1, k)
                }
            } else {
                if (p2[idx - 1] < i) {
                    p2[idx] = i
                    pickMin(idx + 1, k)
                }
            }
        }
    }
}