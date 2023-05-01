package com.example.introvertquiz.view.task

import android.widget.Space
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Bottom
import androidx.compose.ui.Alignment.Companion.Start
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.introvertquiz.R
import com.example.introvertquiz.components.TaskComponent

@Composable
fun TaskView(navController: NavController) {
    val component = TaskComponent()
    val scrollState = rememberScrollState()

    Scaffold(
        topBar = {
            TopAppBar(
                contentColor = Black,
                backgroundColor = White,
                elevation = 8.dp,
                title = {
                    Text(text = "Tugas 01",
                        style = MaterialTheme.typography.h3,
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
        Surface(modifier = Modifier
            .padding(it)
            .fillMaxSize()) {
            Column(
                modifier = Modifier
                    .verticalScroll(scrollState)
            ) {
                Spacer(modifier = Modifier.height(14.dp))
                Column(
                    Modifier
                        .padding(start = 16.dp, end = 16.dp)
                ) {
                    Text(text = "Status",
                        style = MaterialTheme.typography.h3,
                        color = Color.Black,
                        fontSize = 14.sp)
                    Spacer(modifier = Modifier.height(10.dp))
                    Row  {
                        component.TaskStatus(
                            borderStroke = BorderStroke(0.dp, Color.White),
                            color = Color(0xFF2C9009),
                            text = "Attempt")
                        Spacer(modifier = Modifier.width(15.dp))
                        component.TaskStatus(
                            borderStroke = BorderStroke(0.dp, Color.White),
                            color = MaterialTheme.colors.primary,
                            text = "Not Graded")
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "Berkas",
                        style = MaterialTheme.typography.h3,
                        color = Color.Black,
                        fontSize = 14.sp)
                    Spacer(modifier = Modifier.height(10.dp))
                    component.FolderCard()
                }
                Spacer(modifier = Modifier.height(10.dp))
                Divider()
                Spacer(modifier = Modifier.height(10.dp))
                Column(
                    Modifier
                        .padding(start = 16.dp, end = 16.dp)
                ) {
                    Text(text = "Komentar",
                        style = MaterialTheme.typography.h3,
                        color = Color.Black,
                        fontSize = 14.sp)
                    Spacer(modifier = Modifier.height(10.dp))

                    Surface(
                        color = Color.Transparent,
                        border = BorderStroke(1.dp,MaterialTheme.colors.primary),
                        shape = RoundedCornerShape(15.dp),
                        modifier = Modifier
                            .height(68.dp)
                    ) {
                        Box(modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentWidth(Start)
                            .padding(top = 8.dp, start = 12.dp)) {
                            Text(text = "Tidak ada komentar untuk tugas ini",
                                style = MaterialTheme.typography.caption,
                                color = Black,
                                fontSize = 10.sp)
                        }
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
                Divider()
                Spacer(modifier = Modifier.height(10.dp))
                Column(
                    Modifier
                        .padding(start = 16.dp, end = 16.dp)
                ) {
                    Text(text = "Last Modified",
                        style = MaterialTheme.typography.h3,
                        color = Black,
                        fontSize = 14.sp)
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "Jum’at, 2 Februari 2023, 12:00",
                        style = MaterialTheme.typography.body1,
                        color = MaterialTheme.colors.primary,
                        fontSize = 14.sp)

                }
                Spacer(modifier = Modifier.height(10.dp))
                Divider()
                Spacer(modifier = Modifier.height(10.dp))
                Column(
                    Modifier
                        .padding(start = 16.dp, end = 16.dp)
                ) {
                    Text(text = "Time Remaining",
                        style = MaterialTheme.typography.h3,
                        color = Black,
                        fontSize = 14.sp)
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "Assigment was submited 4 jam early",
                        style = MaterialTheme.typography.body1,
                        color = MaterialTheme.colors.primary,
                        fontSize = 14.sp)

                }
                Spacer(modifier = Modifier.height(10.dp))
                Divider()
                Spacer(modifier = Modifier.height(10.dp))
                Column(
                    Modifier
                        .padding(start = 16.dp, end = 16.dp)
                ) {
                    Text(text = "Batas Waktu",
                        style = MaterialTheme.typography.h3,
                        color = Black,
                        fontSize = 14.sp)
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "Juma.at, 2 Februari 2023, 18:00",
                        style = MaterialTheme.typography.body1,
                        color = MaterialTheme.colors.primary,
                        fontSize = 14.sp)

                }
                Spacer(modifier = Modifier.height(10.dp))
                Divider()
                Spacer(modifier = Modifier.weight(1f))
                Box(
                    Modifier
                        .padding(start = 16.dp, end = 16.dp, bottom = 10.dp)
                ) {
                    Button(
                        onClick = {  },
                        shape = RoundedCornerShape(15.dp),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = MaterialTheme.colors.primary,
                            contentColor = White
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Text(text = "EDIT SUBMISSION",
                            style = MaterialTheme.typography.h3,
                            fontSize = 14.sp,
                            modifier = Modifier
                                .padding(top = 8.dp, bottom = 8.dp))
                    }
                }

            }
        }
    }



}