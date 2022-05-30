package thread

import kotlin.concurrent.thread

class MyThread(name: String, private val counter: Counter): Thread(name) {
    override fun run() {
        uselessTask("MyThread", counter)
    }
}

data class Counter(var count: Int = 0) {

    fun increment(): Int {
        return ++count
    }
}
class MyRunnable(private val counter: Counter): Runnable {
    override fun run() {
        uselessTask("MyRunnable", counter)
    }
}

fun uselessTask(context: String, counter: Counter) {
    for (index in 1..100) {
        synchronized(counter) {
            println(message = "$context : ${Thread.currentThread().name} $index ${counter.increment()}")
        }
        Thread.sleep(100)
    }

    println("Finished : ${Thread.currentThread().name}")
}

fun main() {
    val counter = Counter()
    val myThread = MyThread("MySuperThread", counter)
    val myRunnThread = Thread(MyRunnable(counter), "MySuperRunnableThread")
    val myFuncThread = thread(start = false, name = "MySuperFunctionThread", block = { uselessTask("Function-Thread", counter) })

    myThread.start()
    myRunnThread.start()
    myFuncThread.start()

    Thread.currentThread().name = "Main-Thread"
    uselessTask("Main", counter)

    println("Main Finished")
}