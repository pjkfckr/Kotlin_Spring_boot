package com.test.test_spring.resource

import com.test.test_spring.dto.person.AddPersonRequest
import com.test.test_spring.dto.person.PersonResponse
import com.test.test_spring.dto.person.UpdatePersonRequest
import org.springframework.http.ResponseEntity
import org.springframework.web.servlet.function.EntityResponse

interface PersonResource {
    fun findByPersonId(person_id: Long): ResponseEntity<PersonResponse?>
    fun findAll(): ResponseEntity<List<PersonResponse>>
    fun save(addPersonRequest: AddPersonRequest): ResponseEntity<PersonResponse>
    fun update(updatePersonRequest: UpdatePersonRequest): ResponseEntity<PersonResponse>
    fun deleteByPersonId(person_id: Long): ResponseEntity<Unit>
}