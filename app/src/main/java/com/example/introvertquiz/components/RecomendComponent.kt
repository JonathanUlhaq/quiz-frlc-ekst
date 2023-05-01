package com.example.introvertquiz.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.introvertquiz.R
import com.example.introvertquiz.navigation.ContentRoute

class RecomendComponent {

    @OptIn(ExperimentalMaterialApi::class)
    @Composable
    fun RecomendCard(
        title: String,
        navController: NavController
    ) {
        Surface(
            color = MaterialTheme.colors.primary,
            shape = RoundedCornerShape(15.dp),
            contentColor = Color.White,
            elevation = 8.dp,
            onClick = {
                navController.navigate(ContentRoute.Task.route)
            }
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, top = 12.dp, bottom = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.h4,
                    fontSize = 16.sp
                )

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "70 / 100",
                        fontSize = 16.sp
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Icon(
                        painter = painterResource(id = R.drawable.icon_dropdown),
                        contentDescription = null,
                        modifier = Modifier
                            .rotate(-90f)
                            .size(12.dp)
                    )
                }
            }
        }
    }
}