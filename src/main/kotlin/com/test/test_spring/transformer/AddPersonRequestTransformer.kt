package com.test.test_spring.transformer

import com.test.test_spring.domain.Person
import com.test.test_spring.dto.person.AddPersonRequest
import org.springframework.stereotype.Component


@Component
class AddPersonRequestTransformer: Transformer<AddPersonRequest, Person> {
    override fun transform(source: AddPersonRequest): Person {
        return Person(
            name = source.name,
            lastName = source.lastName
        )
    }

}