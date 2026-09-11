package com.example.cardproduto

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = Color.White
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.fillMaxSize()
                ) {
                    ProductCard()
                }
            }
        }
    }
}

@Composable
fun ProductCard() {
    // 1. O card tem cantos redondos: clip aplicado antes do background/border
    Column(
        modifier = Modifier
            .width(300.dp)
            .clip(RoundedCornerShape(12.dp))
            .border(1.dp, Color(0xFF1E3A5F), RoundedCornerShape(12.dp))
            .background(Color.White)
            .padding(16.dp)
    ) {
        // 2. A "imagem" é um Box cinza
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(Color(0xFF8FA7C1))
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Título do Produto
        Text(
            text = "Fone Bluetooth X200",
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF1E3A5F)
        )

        Spacer(modifier = Modifier.height(12.dp))

        // 3. Preço à esquerda, botão à direita (Row com Arrangement.SpaceBetween)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "R$ 249,90",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFE05638)
            )

            Button(
                onClick = { /* Ação de compra */ },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF0F3854)
                ),
                shape = RoundedCornerShape(4.dp)
            ) {
                Text(
                    text = "Comprar",
                    color = Color.White,
                    fontSize = 12.sp
                )
            }
        }
    }
}