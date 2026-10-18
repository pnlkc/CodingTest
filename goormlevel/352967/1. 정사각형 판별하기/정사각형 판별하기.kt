fun main(args: Array<String>) {
    val arr = Array(4) { readLine()!!.split(" ").map { it.toLong() } }
    val distArr = LongArray(6) { 0 }
	var idx = 0
	
    for (i in 0..2) {
        for (j in (i + 1)..3) {
            val diffX = arr[i][0] - arr[j][0]
            val diffY = arr[i][1] - arr[j][1]

            distArr[idx++] = diffX * diffX + diffY * diffY
        }
    }

    distArr.sort()

    if (distArr[0] == distArr[1] && distArr[1] == distArr[2] && distArr[2] == distArr[3] && distArr[4] == distArr[5]) {
        println("yes")
    } else {
        println("no")
    }
}