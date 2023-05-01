package com.example.introvertquiz.view.recomend

import android.widget.Space
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.introvertquiz.R
import com.example.introvertquiz.widget.recomend.RecomendWidget

@Composable
fun RecomendView(navController: NavController) {
    val widget = RecomendWidget()
    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Color.White,
                contentColor = Color.Black,
                elevation = 8.dp,
               title = {
                   Text(text = "Sistem Pemberi Rekomendasi",
                        style = MaterialTheme.typography.h4,
                        fontSize = 16.sp)
               },
                navigationIcon = {
                    IconButton(onClick = {navController.popBackStack() }) {
                        Icon(painter = painterResource(id = R.drawable.icon_dropdown),
                            contentDescription = null,
                            modifier = Modifier
                                .rotate(90f)
                                .size(12.dp))
                    }
                }
            )
        }
    ) {
        Surface(
            modifier = Modifier
                .padding(it)
        ) {
            Column(
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp)
            ) {
                Spacer(modifier = Modifier.height(24.dp))
                widget.RecomendCard(navController = navController)
            }
        }
    }
}