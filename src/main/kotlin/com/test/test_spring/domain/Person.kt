package com.test.test_spring.domain

import javax.persistence.*


@Entity
data class Person(
    @Id
    @SequenceGenerator(name = PERSON_SEQUENCE, sequenceName = PERSON_SEQUENCE, initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = PERSON_SEQUENCE)
    val person_id: Long = 1,
    var name: String = "",
    val age: Int = 0,
    var lastName: String? = ""
    ) {
    companion object {
        const val PERSON_SEQUENCE: String = "PERSON_SEQUENCE"
    }
}