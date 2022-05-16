import kotlinx.coroutines.delay

suspend fun main() {
    println("1. Main Start")
    sendData()
    println("8. Main Finished")
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
