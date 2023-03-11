val result = mutableListOf<Int>()

fun main() {
    val (aSize, k) = readln().split(" ").map { it.toInt() }
    split(readln().split(" ").map { it.toInt() })
    println(if (result.size < k) -1 else result[k - 1])
}

fun split(list: List<Int>): List<Int> {
    if (list.size <= 1) return list

    val left = split(list.slice(0..list.lastIndex / 2))
    val right = split(list.slice(list.lastIndex / 2 + 1..list.lastIndex))

    return merge(left, right)
}

fun merge(left: List<Int>, right: List<Int>): List<Int> {
    val mergeList = mutableListOf<Int>()
    val index = intArrayOf(0, 0)

    while (index[0] < left.size && index[1] < right.size) {
        if (left[index[0]] < right[index[1]]) {
            mergeList.add(left[index[0]])
            result.add(left[index[0]])
            index[0]++
        } else {
            mergeList.add(right[index[1]])
            result.add(right[index[1]])
            index[1]++
        }
    }

    while (index[0] < left.size) {
        mergeList.add(left[index[0]])
        result.add(left[index[0]])
        index[0]++
    }

    while (index[1] < right.size) {
        mergeList.add(right[index[1]])
        result.add(right[index[1]])
        index[1]++
    }

    return mergeList
}