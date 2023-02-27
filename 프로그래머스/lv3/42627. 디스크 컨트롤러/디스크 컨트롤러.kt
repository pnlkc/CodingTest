class Solution {
    fun solution(jobs: Array<IntArray>): Int {
        val mutableJobs = jobs.sortedWith(compareBy<IntArray>() { it[0] }.thenBy { it[1] }).toMutableList()
        var answer = mutableJobs[0][1]
        var time = mutableJobs[0][0] + mutableJobs[0][1]
        mutableJobs.removeFirst()
        while (mutableJobs.isNotEmpty()) {
            val waitList = mutableJobs.filter { it[0] <= time }
            when (waitList.size) {
                0 -> {
                    val job = mutableJobs[0]
                    time = job[0] + job[1]
                    answer += job[1]
                    mutableJobs.removeFirst()
                }
                else -> {
                    val job = waitList.minByOrNull { it[1] }!!
                    answer += time - job[0] + job[1]
                    time += job[1]
                    mutableJobs.remove(job)
                }
            }
        }
        return answer / jobs.size
    }
}