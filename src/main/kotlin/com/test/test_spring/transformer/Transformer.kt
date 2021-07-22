package com.test.test_spring.transformer

interface Transformer <A, B> {
    fun transform(source: A): B
}