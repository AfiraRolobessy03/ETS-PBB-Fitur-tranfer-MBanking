package com.example.mbankingbri.Screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.navigation.NavHostController
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController

@Composable
fun MenuScreen(navController: NavHostController) {
    var selectedTab by remember { mutableStateOf(0) }
    val tabs = listOf("Nomor Rekening", "Kontak BI-FAST")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        // Top Bar
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF0070C0))
                .padding(vertical = 16.dp),
            contentAlignment = Alignment.Center
        ) {
            Text("Penerima Baru", color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.Bold)
        }

        // Tab Row
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .background(Color(0xFF0070C0)),
            horizontalArrangement = Arrangement.Center
        ) {
            tabs.forEachIndexed { index, title ->
                val backgroundColor = if (selectedTab == index) Color.White else Color(0xFF0070C0)
                val textColor = if (selectedTab == index) Color(0xFF0070C0) else Color.White

                Button(
                    onClick = { selectedTab = index },
                    modifier = Modifier
                        .background(
                            color = backgroundColor,
                            shape = RoundedCornerShape(16.dp)
                        ),
                    colors = ButtonDefaults.buttonColors(containerColor = backgroundColor)
                ) {
                    Text(title, color = textColor)
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Form
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Text("Bank Tujuan")
            BasicTextField(
                value = "",
                onValueChange = {},
                modifier = Modifier
                    .background(Color(0xFFF1F1F1), shape = RoundedCornerShape(8.dp))
                    .fillMaxWidth()
                    .padding(16.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))

            Text("Nomor Rekening/Alias")
            BasicTextField(
                value = "",
                onValueChange = {},
                modifier = Modifier
                    .background(Color(0xFFF1F1F1), shape = RoundedCornerShape(8.dp))
                    .fillMaxWidth()
                    .padding(16.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text("Jumlah RP")
            BasicTextField(
                value = "",
                onValueChange = {},
                modifier = Modifier
                    .background(Color(0xFFF1F1F1), shape = RoundedCornerShape(8.dp))
                    .fillMaxWidth()
                    .padding(16.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Navigation Button
            Button(
                onClick = { navController.navigate("pin") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0062F4))

            ) {
                Text("Next")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MenuScreenPreview() {
    MenuScreen(navController = rememberNavController())
}
