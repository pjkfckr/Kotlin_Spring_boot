package com.test.test_spring.dao

import com.test.test_spring.domain.Person
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface PersonDao: JpaRepository<Person, Long>
