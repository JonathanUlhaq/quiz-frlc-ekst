package com.example.introvertquiz.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.End
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.introvertquiz.R
import com.example.introvertquiz.navigation.ContentRoute

class MateriComponent {

    @Composable
    fun TopBar(navController: NavController) {
        Surface(
            Modifier
                .fillMaxWidth(),
            color = Color.White,
            elevation = 8.dp
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 16.dp,top = 10.dp, bottom = 10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row (
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(painter = painterResource(id = R.drawable.icon_dropdown),
                            contentDescription = null,
                            tint = Color.Black,
                            modifier = Modifier
                                .rotate(90f)
                                .size(width = 13.dp, 7.5.dp))
                    }
                    Text(text = "Pembelajaran Mesin Lanjut",
                        style = MaterialTheme.typography.h3,
                        fontSize = 16.sp,
                        color = Color.Black)
                }
                Icon(painter = painterResource(id = R.drawable.action_icon),
                    contentDescription = null,
                    tint = MaterialTheme.colors.primary,)
            }
        }
    }

    @Composable
    fun AnnounceCard(
        title: String,
        desc: String
    ) {
        Surface(
            modifier = Modifier.width(200.dp),
            shape = RoundedCornerShape(15.dp),
            color = Color.White,
            elevation = 6.dp
        ) {
            Box {

                Box(
                    modifier = Modifier
                        .offset(y = -10.dp, x = 12.dp)
                        .fillMaxWidth()
                        .wrapContentWidth(End)
                        .rotate(25F)
                        .height(32.dp)
                        .width(160.dp)
                        .shadow(20.dp, shape = RoundedCornerShape(100))
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentWidth(End)
                ) {

                    Image(
                        painter = painterResource(id = R.drawable.announce_cloud_vector),
                        contentDescription = null
                    )
                }
                Column(modifier = Modifier.padding(11.dp)) {
                    Image(
                        painter = painterResource(id = R.drawable.logo_telkom_universtiy),
                        contentDescription = null
                    )
                    Spacer(modifier = Modifier.height(14.dp))
                    Text(
                        text = title,
                        style = MaterialTheme.typography.h3,
                        color = Color.Black,
                        fontSize = 12.sp
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        text = desc,
                        style = MaterialTheme.typography.h2,
                        color = MaterialTheme.colors.primary,
                        fontSize = 9.sp
                    )
                }
            }
        }
    }

    @OptIn(ExperimentalMaterialApi::class)
    @Composable
    fun TaskCard(navController: NavController) {
        Surface(
            modifier = Modifier.width(185.dp),
            shape = RoundedCornerShape(15.dp),
            color = Color.White,
            elevation = 6.dp,
            onClick = {
                navController.navigate(ContentRoute.Quiz.route)
            }
        ) {
            Box {
                Box(
                    modifier = Modifier
                        .offset(y = 16.dp, x = 2.dp)
                        .fillMaxWidth()
                        .wrapContentWidth(End)
                        .height(62.dp)
                        .width(74.dp)
                        .shadow(8.dp, shape = CircleShape)
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentWidth(End)
                ) {

                    Image(
                        painter = painterResource(id = R.drawable.task_card_cloud),
                        contentDescription = null,
                        modifier = Modifier
                            .offset(y = 8.dp)
                    )
                }

                Column(
                    modifier = Modifier.padding(11.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.logo_telkom_universtiy),
                        contentDescription = null
                    )
                    Spacer(modifier = Modifier.height(14.dp))
                    Text(
                        text = "Tugas W3",
                        style = MaterialTheme.typography.h4,
                        color = Color.Black,
                        fontSize = 12.sp,
                    )
                    Spacer(modifier = Modifier.height(1.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Genetic Algorithm",
                            style = MaterialTheme.typography.body2,
                            color = Color.Black,
                            fontSize = 10.sp
                        )
                        Surface(
                            shape = RoundedCornerShape(5.dp),
                            elevation = 4.dp,
                            color = Color.White,
                            contentColor = MaterialTheme.colors.primary,
                            modifier = Modifier.clickable { }
                        ) {
                            Text(
                                text = "Submit",
                                style = MaterialTheme.typography.h1,
                                fontSize = 8.sp,
                                modifier = Modifier
                                    .padding(start = 6.dp, end = 6.dp, top = 1.dp, bottom = 1.dp)
                            )
                        }
                    }
                }
            }
        }
    }

    @OptIn(ExperimentalMaterialApi::class)
    @Composable
    fun MateriCard(navController: NavController,index:Int) {
        Surface(
            color = MaterialTheme.colors.primary,
            shape = RoundedCornerShape(30.dp),
            elevation = 4.dp,
            modifier = Modifier
                .fillMaxWidth(),
            onClick = {
                navController.navigate(ContentRoute.DetailMateri.route)
            }
        ) {
            Box {
                Box(
                    modifier = Modifier
                        .height(165.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentWidth(End)
                            .height(48.dp)
                            .width(120.dp)
                            .shadow(14.dp, shape = CircleShape)
                    )
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentWidth(End)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.cloud_materi),
                            contentDescription = null
                        )
                    }

                    Box(
                        modifier = Modifier
                            .fillMaxHeight()
                            .wrapContentHeight(Alignment.Bottom)
                            .offset(y = 20.dp, x = -20.dp)
                            .rotate(20F)
                            .clip(CircleShape)
                            .size(height = 120.dp, width = 180.dp)
                            .background(Color.Black.copy(0.1F))
                    )

                }

                Column(
                    modifier = Modifier.padding(top = 15.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.telkom_course_logo),
                            contentDescription = null
                        )
                        Spacer(modifier = Modifier.width(9.dp))
                        Image(
                            painter = painterResource(id = R.drawable.telkom_course_text),
                            contentDescription = null
                        )
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Surface(
                        shape = RoundedCornerShape(15.dp),
                        color = Color.White,
                        elevation = 4.dp,
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 15.dp, top = 15.dp,end = 2.dp,bottom = 15.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Column {
                                    Text(
                                        text = "Evolutionary Clustering",
                                        fontSize = 14.sp,
                                        style = MaterialTheme.typography.h1,
                                        color = Color.Black
                                    )
                                    Spacer(modifier = Modifier.height(2.dp))
                                    Text(
                                        text = "Pertemuan 01",
                                        fontSize = 12.sp,
                                        style = MaterialTheme.typography.body2,
                                        color = Color.Black
                                    )
                                }
                            }
                            IconButton(onClick = { }) {
                                Icon(
                                    painter = if (index > 1) painterResource(id = R.drawable.check_circle) else painterResource(id = R.drawable.check_icon),
                                    contentDescription = null,
                                    tint = if (index > 1)  Color(0xFF6C6C6C) else MaterialTheme.colors.primary
                                )
                            }
                        }
                    }
                }


            }
        }
    }
}