package thread

import kotlin.random.Random

class ThreadExWithRunnable(): Runnable {
    override fun run() {
        while (true) {
            val number = Random.nextInt(100)
            Thread.sleep(100)
            if (number == 0) {
                break
            }
            println(number * number)
        }

        println("${Thread.currentThread().name} is finished")
    }

}

fun main() {
    // Create s runnable thread
    val t1 = Thread(ThreadExWithRunnable())
    // start a thread
    t1.start()


    for (i in 0 until 5_555_555_543L) {
        if (i % 1_000_000_000 == 0L) {
            println("Hello from the main!")
        }
    }
}