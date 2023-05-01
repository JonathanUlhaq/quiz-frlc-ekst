package com.example.introvertquiz.view.materi

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.Start
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.introvertquiz.R
import com.example.introvertquiz.components.MateriComponent
import com.example.introvertquiz.widget.materi.MateriWidget
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

@Composable
fun MateriView(
    navController: NavController
) {
    val component = MateriComponent()
    val widget = MateriWidget()
    val scrollState = rememberScrollState()

    Scaffold(
        topBar = {
            component.TopBar(navController = navController)
        }
    ) {
        Surface(Modifier.padding(it)) {
            Column(
                modifier = Modifier
                    .verticalScroll(scrollState)
            ) {
                Surface(
                    modifier = Modifier
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(bottomEnd = 15.dp, bottomStart = 15.dp),
                    color = MaterialTheme.colors.primary
                ) {
                    Column(
                        modifier = Modifier
                            .padding(start = 16.dp, top = 16.dp, bottom = 20.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Box(modifier = Modifier
                                .clip(CircleShape)
                                .size(10.dp)
                                .background(Color.White))
                            Spacer(modifier = Modifier.width(10.dp))
                            Text(text = "Announcement",
                                style = MaterialTheme.typography.h3,
                                color = Color.White,
                                fontSize = 16.sp)
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                        widget.AnnounceWidget()
                    }
                }
                Spacer(modifier = Modifier.height(10.dp))
                Column(
                    modifier = Modifier
                        .padding(start = 16.dp, bottom = 12.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .padding(end = 16.dp)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
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
                                text = "Tugas dan Kuis",
                                fontSize = 16.sp,
                                style = MaterialTheme.typography.h3,
                                color = Color.Black
                            )
                        }

                        IconButton(onClick = { }) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = "View All",
                                    fontSize = 14.sp,
                                    color = MaterialTheme.colors.primary,
                                    style = MaterialTheme.typography.body1
                                )
                                Spacer(modifier = Modifier.width(6.dp))
                                Icon(
                                    painter = painterResource(id = R.drawable.icon_dropdown),
                                    contentDescription = null,
                                    tint = MaterialTheme.colors.primary,
                                    modifier = Modifier.rotate(-90F)
                                )
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    widget.TaskQuizWidget(navController)
                    Spacer(modifier = Modifier.height(10.dp))
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
                            text = "Materi",
                            fontSize = 16.sp,
                            style = MaterialTheme.typography.h3,
                            color = Color.Black
                        )
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Box(modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentWidth(Start)) {
                        Column(
                            modifier = Modifier.padding(end = 16.dp)
                        ) {
                            widget.MateriCardWidget(navController)
                        }
                    }
                }

            }
        }
    }
}