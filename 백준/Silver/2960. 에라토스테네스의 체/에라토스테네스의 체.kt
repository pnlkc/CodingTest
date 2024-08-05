fun main() {
    val (N, K) = readln().split(" ").map { it.toInt() }
    val arr = BooleanArray(N + 1)
    var cnt = 0

    for (i in 2..N) {
       if (!arr[i]) {
           var num = i

           while (num <= N) {
               if (!arr[num]) {
                   if (++cnt == K) {
                       println(num)
                       return
                   } else {
                       arr[num] = true
                   }
               }

               num += i
           }
       }
    }
}