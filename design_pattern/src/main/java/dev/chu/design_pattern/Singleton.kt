package dev.chu.design_pattern

class Singleton01 {
    companion object {
        private var instance: Singleton01? = null
        fun getInstance(): Singleton01 {
            if (instance == null) {
                synchronized(this) {
                    if (instance == null) {
                        instance = Singleton01()
                    }
                }
            }
            return instance!!
        }
    }

    fun print() {
        println("Singleton01")
    }
}

object Singleton02 {

    fun print() {
        println("Singleton02")
    }
}