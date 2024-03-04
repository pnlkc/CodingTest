import java.lang.StringBuilder

val divNum = 1_000_000_009

fun main() {
    val T = readln().toInt()
    val sb = StringBuilder()
    val arr = IntArray(1_000_001)

    init(arr)

    for (tc in 1..T) {
        val num = readln().toInt()

        sb.appendLine(arr[num])
    }

    print(sb)
}

fun init(arr: IntArray) {
    arr[1] = 1
    arr[2] = 2
    arr[3] = 4

    for (i in 4..1_000_000) {
        arr[i] = (arr[i - 3] + arr[i - 2]) % divNum
        arr[i] = (arr[i] + arr[i - 1]) % divNum
    }
}