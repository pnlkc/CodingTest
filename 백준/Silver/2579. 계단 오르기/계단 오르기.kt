fun main() {
    val num = readln().toInt()
    val list = IntArray(num + 1) { if (it == 0) 0 else readln().toInt() }
    val memo = Array(num + 1) { IntArray(2) }
    memo[num] = intArrayOf(list.last(), list.last())
    calc(list, num, false, memo)
    println(memo.first().maxOrNull()!!)
}

fun calc(list: IntArray, cPos: Int, needTwoStep: Boolean, memo: Array<IntArray>) {
    if (cPos <= 0) return

    val index = if (cPos - 2 < 0) 0 else cPos - 2
    memo[index][0] = maxOf(
        memo[cPos][0] + list[index],
        memo[cPos][1] + list[index],
        memo[index][0]
    )

    memo[cPos - 1][1] = maxOf(
        memo[cPos][0] + list[cPos - 1],
        memo[cPos - 1][1]
    )

    calc(list, cPos - 1, needTwoStep, memo)
}