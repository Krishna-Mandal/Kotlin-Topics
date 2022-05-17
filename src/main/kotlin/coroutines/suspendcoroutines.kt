package coroutines

import kotlinx.coroutines.*
import kotlinx.datetime.Clock

suspend fun main() {
    println("================ Suspend =========================")
    println("1. Main Suspend Start")
    sendData()
    println("8. Main Suspend Finished")

    println("================ run Blocking =========================")
    println("1. Main RunBlocking Start")
    sendDataRunBlocking()
    println("8. Main RunBlocking Finished")

    println("================ GlobalScope launch =========================")
    println("1. Main RunBlocking Start")
    sendDataAsync()
    println("8. Main RunBlocking Finished")
}
@OptIn(DelicateCoroutinesApi::class)
suspend fun sendDataAsync() {
    val current = Clock.System.now()
    val asyncSend = GlobalScope.launch {
        val data = prepareRequest()
        val result = submitRequest(data)
        processResult(result)
    }

    while (!asyncSend.isCompleted) {
        delay(1000)
        println("waiting since ${Clock.System.now() - current}: isActive: ${asyncSend.isActive}")
    }
}

fun sendDataRunBlocking() {
    runBlocking {
        val data = prepareRequest()
        val result = submitRequest(data)
        processResult(result)
    }
}
suspend fun sendData() {
    val data = prepareRequest() // long-running operation
    val result = submitRequest(data) // another long-running operation
    processResult(result)
}

fun processResult(result: MutableList<Int>) {
    println("6. Processing Result Start")
    for (element in result) {
        println("Process: $element")
    }
    println("7. Processing Result Finished")
}

suspend fun submitRequest(data: MutableList<Int>): MutableList<Int> {
    println("4. Submit Request Start")
    for (element in data) {
        println("submit: $element")
        suspend { }
        delay(1000)
    }
    println("5. Submit Request Finished")
    return data
}

suspend fun prepareRequest(): MutableList<Int> {
    val list = mutableListOf<Int>()

    println("2. Prepare Request Start")
    for (index in 0..5) {
        list.add(index)
        delay(1000)
    }
    println("3. Prepare Request Finished")
    return list
}
