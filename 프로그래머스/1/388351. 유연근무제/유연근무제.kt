class Solution {
  fun solution(schedules: IntArray, timelogs: Array<IntArray>, startday: Int): Int {
    var answer = 0
    val len = schedules.size

    p@ for (i in 0 until len) {
      var idx = startday

      var limit = schedules[i] + 10
      if (limit % 100 >= 60) {
        limit = limit - 60 + 100
      }

      for (j in 0 until 7) {
        if (idx != 6 && idx != 7) {
          if (timelogs[i][j] > limit) continue@p
        }

        if (++idx > 7) idx = 1
      }

      answer++
    }

    return answer
  }
}