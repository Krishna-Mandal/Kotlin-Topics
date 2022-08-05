package html

import kotlinx.html.body
import kotlinx.html.div
import kotlinx.html.dom.append
import kotlinx.html.dom.document
import kotlinx.html.dom.serialize
import kotlinx.html.html

fun main() {
    val myDocument = document { }
    myDocument.append {
        html {
            body {
                for (i in 1..10) {
                    div {
                        +i.toString()
                    }
                }
            }
        }
    }
    println(myDocument.serialize())
}