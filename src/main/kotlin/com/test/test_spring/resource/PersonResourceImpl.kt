package com.test.test_spring.resource

import com.test.test_spring.dto.person.AddPersonRequest
import com.test.test_spring.dto.person.PersonResponse
import com.test.test_spring.dto.person.UpdatePersonRequest
import com.test.test_spring.resource.PersonResourceImpl.Companion.BASE_PERSON_URL
import com.test.test_spring.service.PersonManagementService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.function.EntityResponse
import java.net.URI


@RestController
@RequestMapping(value = [BASE_PERSON_URL], )
class PersonResourceImpl(private val personManagementService: PersonManagementService) : PersonResource {

    @GetMapping("/{person_id}")
    override fun findByPersonId(@PathVariable person_id: Long): ResponseEntity<PersonResponse?> {
        val personResponse: PersonResponse? = this.personManagementService.findByPersonId(person_id)
        return ResponseEntity.status(HttpStatus.OK).body(personResponse)
    }

    @GetMapping
    override fun findAll(): ResponseEntity<List<PersonResponse>> = ResponseEntity.status(HttpStatus.OK).body(this.personManagementService.findAll())

    @PostMapping
    override fun save(@RequestBody addPersonRequest: AddPersonRequest): ResponseEntity<PersonResponse> {
        val personResponse = this.personManagementService.save(addPersonRequest)
        return ResponseEntity
            .created(URI.create(BASE_PERSON_URL.plus("/${personResponse.person_id}")))
            .body(personResponse)
    }

    @PutMapping
    override fun update(@RequestBody updatePersonRequest: UpdatePersonRequest): ResponseEntity<PersonResponse> {
        return ResponseEntity.ok(this.personManagementService.update(updatePersonRequest))
    }

    @DeleteMapping("/{person_id}")
    override fun deleteByPersonId(@PathVariable person_id: Long): ResponseEntity<Unit> {
        this.personManagementService.deleteByPersonId(person_id)
        return ResponseEntity.noContent().build()
    }

    companion object {
        const val BASE_PERSON_URL: String = "/api/v1/person"
    }
}