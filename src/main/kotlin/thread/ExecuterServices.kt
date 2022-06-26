package thread

import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.concurrent.ScheduledExecutorService
import java.util.concurrent.TimeUnit

fun main() {
    val numTasks = 10
    val poolSize = Runtime.getRuntime().availableProcessors()
    fixedSizeExecutors(numTasks, poolSize)
    scheduledExecutors()
}
fun fixedSizeExecutors(numTasks: Int, poolSize: Int) {
    println("pool size: $poolSize")
    val executor: ExecutorService = Executors.newFixedThreadPool(poolSize)

    for (index in 0..numTasks) {
        executor.submit{
            uselessTask(index)
        }
    }

    executor.shutdown()

    val terminated = executor.awaitTermination(60, TimeUnit.MILLISECONDS)

    if (terminated) {
        println("The executor was successfully stopped")
    } else {
        println("Timeout elapsed before termination")
    }
}

fun scheduledExecutors() {

    val executor: ScheduledExecutorService = Executors.newSingleThreadScheduledExecutor()

    executor.scheduleAtFixedRate(
        { uselessTask(0) },
        1000,
        1000,
        TimeUnit.MILLISECONDS
    )
}
fun uselessTask(index: Int) {
    val taskName = "task-$index"
    val threadName = Thread.currentThread().name

    println("$threadName executes $taskName")
}