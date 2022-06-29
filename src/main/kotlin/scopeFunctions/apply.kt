package scopeFunctions

fun main() {
    Person("Krishna", 35, "Mysore").apply {
        println(this)
        incrementAge()
        moveTo("Munich")
        println(this)
    }
}
