package logger

import mu.KotlinLogging

class Main {

    companion object {
        private val logger = KotlinLogging.logger {}
        @JvmStatic
        fun main(args: Array<String>) {

            logger.info { "in Main" }
            logger.info { logger.underlyingLogger}
        }
    }
}