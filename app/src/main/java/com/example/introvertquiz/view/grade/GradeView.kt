package com.example.introvertquiz.view.grade

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.Start
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.introvertquiz.components.GradeComponent
import com.example.introvertquiz.widget.grade.GradeWidget

@Composable
fun GradeView(navController: NavController) {
    val widget = GradeWidget()
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                        Text(text = "Nilai - nilai",
                            style = MaterialTheme.typography.h3,
                            fontSize = 16.sp,
                            color = Color.Black)
                },
                elevation = 8.dp,
                backgroundColor = Color.White
            )
        }
    ) {
        Surface(
            modifier = Modifier
                .padding(it)
        ) {
            Column(Modifier
                .padding(16.dp)) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(topEnd = 30.dp, bottomEnd = 30.dp))
                            .size(height = 28.dp, width = 5.dp)
                            .background(MaterialTheme.colors.primary)
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        text = "Course",
                        fontSize = 16.sp,
                        style = MaterialTheme.typography.h3,
                        color = Color.Black
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(Start)) {
                    Column {
                        widget.CourseWidge(navController)
                    }
                }
            }
        }
    }
}