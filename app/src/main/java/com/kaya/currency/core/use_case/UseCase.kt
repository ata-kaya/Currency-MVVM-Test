package com.kaya.currency.core.use_case

abstract class UseCase<T> {
    abstract fun execute(): T
}