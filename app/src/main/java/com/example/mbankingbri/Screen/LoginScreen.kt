package com.example.mbankingbri.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.mbankingbri.R

@Composable
fun LoginScreen(navController: NavHostController) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0070C0)),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .background(Color.White)
                .padding(16.dp)
                .fillMaxSize()
                .padding(horizontal = 32.dp, vertical = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.brimo), // Adjust this to your image resource name
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp) // Adjust size as needed
                    .padding(bottom = 16.dp)
            )

            BasicTextField(
                value = username,
                onValueChange = { username = it },
                modifier = Modifier
                    .background(Color(0xFFF1F1F1))
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                decorationBox = { innerTextField ->
                    Box(
                        Modifier
                            .padding(16.dp)
                    ) {
                        if (username.isEmpty()) {
                            Text("username", color = Color.Gray)
                        }
                        innerTextField()
                    }
                }
            )

            Spacer(modifier = Modifier.height(8.dp))

            BasicTextField(
                value = password,
                onValueChange = { password = it },
                modifier = Modifier
                    .background(Color(0xFFF1F1F1))
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                visualTransformation = PasswordVisualTransformation(),
                decorationBox = { innerTextField ->
                    Box(
                        Modifier
                            .padding(16.dp)
                    ) {
                        if (password.isEmpty()){
                            Text("Password", color = Color.Gray)
                        }
                        innerTextField()
                    }
                }
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    // Navigate to MenuScreen
                    navController.navigate("menu")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0062F4))
            ) {
                Text("Login")
            }


            Spacer(modifier = Modifier.height(8.dp))

            TextButton(
                onClick = { /* Handle forgot password */ }
            ) {
                Text("Lupa Username/Password", fontSize = 12.sp)
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen(rememberNavController())
}
