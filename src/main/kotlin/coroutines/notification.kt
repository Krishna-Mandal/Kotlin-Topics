package coroutines

import kotlinx.coroutines.*

@OptIn(DelicateCoroutinesApi::class)
suspend fun main() {
    val job1 = GlobalScope.launch { doAllTheJob1() }
    val job2 = GlobalScope.launch { doAllTheJob2() }

    job1.join()
    job2.join()

    doAllTheJob()
}

@OptIn(DelicateCoroutinesApi::class)
fun doAllTheJob() {
    // put your code here
    runBlocking {
        GlobalScope.launch {
            printProgress()
        }
        loadData()
    }
}

suspend fun loadData() {
    println("Loading Data...")
    delay(5000)
    println("Loading finished")
}

suspend fun printProgress() {
    while (true) {
        println("Working on it...")
        delay(1000)
    }
}

suspend fun doAllTheJob1() {
    println("Started Job 1")
    delay(5000)
    println("Finished Job 1")
}

suspend fun doAllTheJob2() {
    println("Started Job 2")
    delay(3000)
    println("Finished Job 2")
}

