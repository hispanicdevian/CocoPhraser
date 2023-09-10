package com.example.cocophraser

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.random.Random

@Composable
fun CocoPhraserScreen() {
    var generatedPassword by remember { mutableStateOf("") }
    var desiredPasswordLength by remember { mutableStateOf(10f) }

    // List of dictionary words (you can replace it with your own words)
    val dictionaryWords = FourThousandWords.words

    // Function to generate a random character
    fun generateRandomCharacter(): Char {
        val charset = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()_-+=<>?/[]{},.:;"
        return charset[Random.nextInt(charset.length)]
    }

    fun generateRandomPassword() {
        val dictionaryWord = dictionaryWords.random()
        val dictionaryPasswordLength = dictionaryWord.length

        // Calculate the desired password length based on the slider value
        val desiredLength = desiredPasswordLength.toInt()

        // Calculate the length of random characters needed to meet the desired length
        val remainingLength = desiredLength - dictionaryPasswordLength

        if (remainingLength <= 0) {
            // The dictionary word is long enough; use it as is
            generatedPassword = dictionaryWord.substring(0, desiredLength)
        } else {
            // Generate random characters to fill the remaining length
            val randomChars = buildString {
                repeat(remainingLength) {
                    append(generateRandomCharacter())
                }
            }

            // Combine the dictionary word and random characters
            val password = dictionaryWord + randomChars

            generatedPassword = password
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Coco Phraser", fontSize = 24.sp)

            Spacer(modifier = Modifier.padding(16.dp))

            Text("Desired Length: ${desiredPasswordLength.toInt()}", fontSize = 16.sp)

            Spacer(modifier = Modifier.padding(4.dp))

            // Slider for specifying the password length
            Slider(
                value = desiredPasswordLength,
                onValueChange = {
                    desiredPasswordLength = it
                },
                valueRange = 10f..16f, // Adjust the range as needed
                steps = 0.1f.toInt(), // The step size
                modifier = Modifier
                    .width(200.dp)
                    .padding(8.dp)
            )

            Spacer(modifier = Modifier.padding(4.dp))

            Box(
                modifier = Modifier
                    .width(200.dp)
                    .border(
                        width = 1.dp,
                        color = Color.Black,
                        shape = RoundedCornerShape(4.dp)
                    )
                    .padding(8.dp)

            ) {
                Text(
                    text = generatedPassword,
                    fontSize = 18.sp,
                    color = Color.Gray,
                    modifier = Modifier.align(Alignment.Center)
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            Button(onClick = {
                CoroutineScope(Dispatchers.Default).launch {
                    generateRandomPassword()
                }
            }) {
                Text("Coco Password")
            }

            Spacer(modifier = Modifier.padding(bottom = 32.dp))
        }
    }
}