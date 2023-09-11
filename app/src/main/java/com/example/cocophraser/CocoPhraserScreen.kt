package com.example.cocophraser

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cocophraser.ui.theme.CocoBrown
import com.example.cocophraser.ui.theme.CocoGreen

@Composable
fun CocoPhraserScreen(viewModel: CocoPhraserViewModel) {

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
            Spacer(modifier = Modifier.padding(16.dp))

            Text(
                "Coco Phraser",
                fontSize = 28.sp,
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Bold
            )

            Image(
                painter = painterResource(R.mipmap.coco_phraser_shell_foreground),
                contentDescription = "Image content description"
            )

            Text(
                "Desired Length: ${viewModel.desiredPasswordLength}",
                fontSize = 16.sp
            )

            Spacer(modifier = Modifier.padding(16.dp))

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
                    text = viewModel.generatedPassword,
                    fontSize = 18.sp,
                    color = Color.Gray,
                    modifier = Modifier.align(Alignment.Center)
                )
            }

            Spacer(modifier = Modifier.padding(8.dp))

            Slider(
                value = viewModel.desiredPasswordLength.toFloat(),
                onValueChange = {
                    viewModel.desiredPasswordLength = it.toInt()
                },
                valueRange = 10f..16f,
                steps = 0.1f.toInt(),
                modifier = Modifier.width(200.dp).padding(8.dp),
                colors = SliderDefaults.colors(
                    activeTickColor = Color.Transparent,
                    inactiveTickColor = Color.Transparent,
                    inactiveTrackColor = Color.LightGray,
                    activeTrackColor = CocoGreen,
                    thumbColor = CocoGreen
                )
            )

            Spacer(modifier = Modifier.height(22.dp))

            Button(
                colors = ButtonDefaults.buttonColors(CocoBrown),
                onClick = {
                    viewModel.generateRandomPassword()
                }
            ) {
                Spacer(modifier = Modifier.height(50.dp))
                Text("Generate Passphrase")
            }

            Spacer(modifier = Modifier.padding(bottom = 26.dp))

            Image(
                painter = painterResource(R.mipmap.coco_phraser_leaf_foreground),
                contentDescription = "Image content description",
                Modifier.size(200.dp)
            )
        }
    }
}
