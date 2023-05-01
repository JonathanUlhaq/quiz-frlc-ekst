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
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.introvertquiz.R
import com.example.introvertquiz.navigation.ContentRoute

class GradeComponent {

    @Composable
    fun CourseCard(navController: NavController) {
        Surface(
            color = MaterialTheme.colors.primary,
            shape = RoundedCornerShape(20.dp),
            elevation = 4.dp,
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    navController.navigate(ContentRoute.Recomend.route)
                }
        ) {
            Box {
                Box(
                    modifier = Modifier
                        .height(104.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentWidth(Alignment.End)
                            .offset(y = -20.dp,x = -28.dp)
                            .rotate(15F)
                            .clip(CircleShape)
                            .size(height = 60.dp, width = 70.dp)
                            .background(Color.Black.copy(0.1F))

                    )
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentWidth(Alignment.End)
                            .offset(y = 24.dp,x = -60.dp)
                            .height(48.dp)
                            .width(80.dp)
                            .shadow(14.dp, shape = CircleShape)
                    )
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentWidth(Alignment.End)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.value_cloud),
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
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(start = 15.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.telkom_course_logo),
                            contentDescription = null,
                            modifier = Modifier
                                .size(height = 48.dp, width = 37.dp)
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Image(
                            painter = painterResource(id = R.drawable.telkom_course_text),
                            contentDescription = null,
                            modifier = Modifier
                                .size(height = 34.dp, width = 73.dp)
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
                                .padding(15.dp),
                            verticalAlignment = Alignment.Bottom,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = "Pembelajaran Mesin Lanjut - SUO",
                                    fontSize = 14.sp,
                                    style = MaterialTheme.typography.h1,
                                    color = Color.Black
                                )
                            }


                        }
                    }
                }


            }
        }
    }
}