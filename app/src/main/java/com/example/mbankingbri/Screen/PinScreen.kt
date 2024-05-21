package com.example.mbankingbri.Screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PinScreen(navController: NavHostController) {
    var pin by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Masukkan PIN",
            fontSize = 24.sp,
            color = Color.Blue,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            for (i in 0 until 6) {
                OutlinedTextField(
                    value = pin.getOrNull(i)?.toString() ?: "",
                    onValueChange = { newValue ->
                        if (newValue.length <= 1 && newValue.all { it.isDigit() }) {
                            val updatedPin = pin.toMutableList()
                            if (updatedPin.size > i) {
                                updatedPin[i] = newValue.singleOrNull() ?: ' '
                            } else {
                                updatedPin.add(newValue.singleOrNull() ?: ' ')
                            }
                            pin = updatedPin.joinToString("").trimEnd()
                        }
                    },
                    modifier = Modifier
                        .size(50.dp),
                    singleLine = true,
                    textStyle = TextStyle(textAlign = TextAlign.Center),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color.Gray,
                        unfocusedBorderColor = Color.Gray,
                    )
                )
            }
        }


        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = {
                // Navigate to SuccessScreen
                navController.navigate("success")
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0062F4))
        ) {
            Text(
                text = "Next",
                color = Color.White,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}
