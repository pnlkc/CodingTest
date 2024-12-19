fun main() {
	val arr = IntArray(5_001)

	for (i in 1..5000) {
		if (i.toString().toCharArray().distinct().size == i.toString().length) {
			arr[i] = arr[i - 1] + 1
		} else {
			arr[i] = arr[i - 1]
		}
	}

	while(true) {
		val input = readLine()
		if (input == null) break
		
		val (N, M) = input.split(" ").map { it.toInt() }
		println(arr[M] - arr[N - 1])
	}
}