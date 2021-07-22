package com.test.test_spring.service

import com.test.test_spring.domain.Person
import com.test.test_spring.dto.person.AddPersonRequest
import com.test.test_spring.dto.person.PersonResponse
import com.test.test_spring.dto.person.UpdatePersonRequest

interface PersonManagementService {
    fun findByPersonId(person_id: Long): PersonResponse?
    fun findAll(): List<PersonResponse>
    fun save(addPersonRequest: AddPersonRequest): PersonResponse
    fun update(updatePersonRequest: UpdatePersonRequest): PersonResponse
    fun deleteByPersonId(person_id: Long)
}