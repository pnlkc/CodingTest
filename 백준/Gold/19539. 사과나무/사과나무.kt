fun main() {
    val N = readln().toInt()
    val list = readln().split(" ").map { it.toInt() }

    if (list.sum() % 3 != 0) {
        println("NO")
        return
    }

    var cntOne = list.count { it == 1 }
    var cntTwo = 0

    for (num in list) {
        if (num > 1) {
            cntTwo += num / 2
            cntOne += num % 2
        }
    }

    if (cntOne > cntTwo || (cntTwo - cntOne) % 3 != 0) {
        println("NO")
        return
    }

    println("YES")
}