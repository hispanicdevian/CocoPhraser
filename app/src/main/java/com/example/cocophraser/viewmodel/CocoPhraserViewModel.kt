package com.example.cocophraser.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.cocophraser.model.CocoPhraserModel

class CocoPhraserViewModel {

    private val model = CocoPhraserModel()

    var generatedPassword by mutableStateOf("")

    var desiredPasswordLength by mutableStateOf(10)

    fun generateRandomPassword() {
        val password = model.generateRandomPassword(desiredPasswordLength)
        generatedPassword = password
    }
}
