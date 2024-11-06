var b = 0
var list = listOf<Int>()
var isUsed = booleanArrayOf()
var result = Int.MAX_VALUE

fun main() {
    val (A, B) = readln().split(" ").map { it.toInt() }

    if (A.toString().length > B.toString().length) {
        println(-1)
        return
    } else if (A.toString().length < B.toString().length) {
        println(A.toString().map { it.digitToInt() }.sortedDescending().joinToString(""))
        return
    }

    list = A.toString().map { it.digitToInt() }.sorted()
    isUsed = BooleanArray(A.toString().length)
    b = B
    pick("", B.toString().map { it.digitToInt() }.sorted())

    println(if (result != Int.MAX_VALUE) result else -1)
}

fun pick(str: String, target: List<Int>) {
    if (str.length == list.size) {
        if (str[0] != '0' && str.toInt() < b) {
            result = if (result == Int.MAX_VALUE) {
                str.toInt()
            } else {
                maxOf(result, str.toInt())
            }
        }
        return
    }

    for (i in list.lastIndex downTo 0) {
        if (isUsed[i]) continue

        isUsed[i] = true
        pick(str + list[i], target)
        isUsed[i] = false
    }
}