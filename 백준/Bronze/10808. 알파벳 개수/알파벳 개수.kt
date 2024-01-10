fun main() {
    val S = readln()
    val arr = IntArray(26)

    for (i in S.indices) {
        arr[S[i] - 'a']++
    }

    println(arr.joinToString(" "))
}