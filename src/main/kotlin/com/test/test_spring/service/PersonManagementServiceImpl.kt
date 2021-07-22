package com.test.test_spring.service

import com.test.test_spring.dao.PersonDao
import com.test.test_spring.domain.Person
import com.test.test_spring.dto.person.AddPersonRequest
import com.test.test_spring.dto.person.PersonResponse
import com.test.test_spring.dto.person.UpdatePersonRequest
import com.test.test_spring.transformer.AddPersonRequestTransformer
import com.test.test_spring.transformer.toPersonResponse
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.lang.IllegalStateException

@Service
class PersonManagementServiceImpl(private val personDao: PersonDao,
                                  private val addPersonRequestTransformer: AddPersonRequestTransformer
                                  ) : PersonManagementService {
    override fun findByPersonId(person_id: Long): PersonResponse? = this.findPersonByPersonId(person_id).toPersonResponse()

    override fun findAll(): List<PersonResponse> = this.personDao.findAll().map(Person::toPersonResponse)

    override fun save(addPersonRequest: AddPersonRequest): PersonResponse {
        return this.saveOrUpdate(
            addPersonRequestTransformer.transform(addPersonRequest)
        )
    }

    override fun update(updatePersonRequest: UpdatePersonRequest): PersonResponse {
        val person = (this.findPersonByPersonId(updatePersonRequest.person_id)
            ?: throw IllegalStateException("${updatePersonRequest.person_id} not found"))

        return this.saveOrUpdate(person.apply {
            this.name = updatePersonRequest.name
            this.lastName = updatePersonRequest.lastName
        })
    }

    override fun deleteByPersonId(person_id: Long) {
        this.personDao.deleteById(person_id)
    }

    private fun findPersonByPersonId(person_id: Long): Person? = this.personDao.findByIdOrNull(person_id)

    private fun saveOrUpdate(person: Person): PersonResponse = this.personDao.save(person).toPersonResponse()
}