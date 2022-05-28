package thread

class ThreadProperties (): Thread() {
    override fun run() {
        println("name       : ${this.name}")        // Name of the thread
        println("id         : ${this.id}")          // id of the thread
        println("isAlive    : ${this.isAlive}")     // If the thread is still alive
        println("Priority   : ${this.priority}")    // Priority of the thread 0..10
        println("isDaemon   : ${this.isDaemon}")    // is daemon.jvm does not wait for daemon thread to finish.
        println("state      : ${this.state}")       // Current state of thread
    }
}

fun main() {
    val t1 = ThreadProperties()
    t1.start()
}