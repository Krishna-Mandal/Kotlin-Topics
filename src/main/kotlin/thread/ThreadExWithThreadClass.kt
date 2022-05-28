package thread

import kotlin.random.Random

class ThreadExWithThreadClass(name: String): Thread(name) {
    override fun run() {
        while (true) {
            val number = Random.nextInt(100)
            sleep(100)
            if (number == 0) {
                break
            }
            println(number * number)
        }

        println("$name is finished")
    }
}

fun main() {
    // Create a thread Object
    val t1 = ThreadExWithThreadClass("Example-Thread-Class")
    // Start thread
    t1.start()

    for (i in 0 until 5_555_555_543L) {
        if (i % 1_000_000_000 == 0L) {
            println("Hello from the main!")
        }
    }
}