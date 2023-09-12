package com.example.cocophraser.model

import kotlin.random.Random

class CocoPhraserModel {

    private val dictionaryWords = LocalWordList.words

    fun generateRandomPassword(desiredPasswordLength: Int): String {
        val dictionaryWord = dictionaryWords.random()
        val dictionaryPasswordLength = dictionaryWord.length

        val remainingLength = desiredPasswordLength - dictionaryPasswordLength

        return if (remainingLength <= 0) {
            dictionaryWord.substring(0, desiredPasswordLength)
        } else {
            val randomChars = buildString {
                repeat(remainingLength) {
                    append(generateRandomCharacter())
                }
            }
            dictionaryWord + randomChars
        }
    }

    private fun generateRandomCharacter(): Char {
        val charset = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()_-+=<>?/[]{},.:;"
        return charset[Random.nextInt(charset.length)]
    }
}