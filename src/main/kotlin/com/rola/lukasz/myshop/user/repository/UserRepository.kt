package com.rola.lukasz.myshop.user.repository

import com.rola.lukasz.myshop.user.model.User
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class UserRepository {
    private val users = listOf(
        User(
            id = UUID.fromString("f8035e24-a14b-4557-a25e-0bdbec85eb1f"),
            name = "John Smith",
            address = "Wrocław 52-129 Staussa 3/10",
            phoneNumber = "566565566"
        ),
        User(
            id = UUID.fromString("0ca1a570-bf10-45f8-99f4-ccf602cac483"),
            name = "Wallace Johnson",
            address = "Wrocław 52-129 Staussa 4/10",
            phoneNumber = "566565566"
        )
    )

    fun findUserById(id: UUID): User{
        return users.firstOrNull { it.id == id } ?: throw Exception("User not found")
    }
}