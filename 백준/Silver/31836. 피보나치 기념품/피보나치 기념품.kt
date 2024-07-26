fun main() {
    val N = readln().toInt()

    when (N) {
        2 -> println("1\n1\n1\n2")
        else -> {
            var num = N
            val l1 = mutableListOf<Int>()
            val l2 = mutableListOf<Int>()

            while (num >= 3) {
                l1.add(num)
                l2.add(--num)
                l2.add(--num)
                num--
            }

            if (num == 2) {
                l1.add(1)
                l2.add(2)
            }

            println(l1.size)
            println(l1.sorted().joinToString(" "))
            println(l2.size)
            println(l2.sorted().joinToString(" "))
        }
    }
}