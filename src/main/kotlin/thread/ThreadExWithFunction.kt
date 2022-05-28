package thread

import kotlin.concurrent.thread
import kotlin.random.Random

fun someFunction() {
        while (true) {
            val number = Random.nextInt(100)
            Thread.sleep(100)
            if (number == 0) {
                break
            }
            println(number * number)
        }
}

fun main() {
    val t1  = thread(start = false,
        name = "function-thread",
        block = {
            someFunction()
            println("${Thread.currentThread().name} finished")
        })
    t1.start()

    for (i in 0 until 5_555_555_543L) {
        if (i % 1_000_000_000 == 0L) {
            println("Hello from the main!")
        }
    }
}