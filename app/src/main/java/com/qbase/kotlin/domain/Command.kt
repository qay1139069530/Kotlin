package com.qbase.kotlin.domain

public interface Command<T> {
    fun execute(): T
}