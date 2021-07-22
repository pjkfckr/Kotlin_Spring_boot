package com.test.test_spring.transformer

import com.test.test_spring.domain.Person
import com.test.test_spring.dto.person.PersonResponse
import org.springframework.http.ResponseEntity


fun Person?.toPersonResponse(): PersonResponse {
    return PersonResponse(
        person_id = this?.person_id?: 1L,
        fullName = "${this?.lastName}, ${this?.name}"
    )
}