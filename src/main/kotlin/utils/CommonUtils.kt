package utils

import kotlinx.coroutines.Job

fun getElapsedTime(startTime:Long):Long{
    val endTime = System.currentTimeMillis()
    return endTime - startTime
}
fun printJobState(job:Job){
    println(
        "is Active: ${job.isActive} " +
                "is Completed: ${job.isCompleted} " +
                "is Canceled: ${job.isCancelled}"
    )

}