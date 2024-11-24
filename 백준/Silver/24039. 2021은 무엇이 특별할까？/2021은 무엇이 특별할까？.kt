fun main() {
    val N = readln().toInt()
    val nList = mutableListOf<Int>()
    val list = mutableListOf<Int>()
    val arr = BooleanArray(10_001) { true }
    arr[0] = false
    arr[1] = false

    for (i in 2..10_000) {
        var num = i + i

        while (num <= 10_000) {
            arr[num] = false
            num += i
        }
    }

    for (i in 2..10_000) {
        if (arr[i]) nList.add(i)
    }

    for (i in 0 until nList.lastIndex) {
        list.add(nList[i]* nList[i + 1])
    }

    list.sort()

    for (num in list) {
        if (num > N) {
            println(num)
            return
        }
    }
}