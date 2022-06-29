package scopeFunctions

fun main() {
    val retval = with(Person("Krishna", 35, "Mysore")) {
        println(this)
        incrementAge()
        moveTo("Munich")
        println(this)

        "$name  $age  DONTKNOW"
    }

    println(retval)
}
