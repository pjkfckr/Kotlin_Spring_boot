package com.test.test_spring.dto.person

data class UpdatePersonRequest(
    val person_id: Long,
    val name: String,
    val age: Number,
    val lastName: String?
)