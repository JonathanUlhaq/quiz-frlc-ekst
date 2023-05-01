package com.example.introvertquiz.components

import android.widget.Space
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Bottom
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Alignment.Companion.End
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.introvertquiz.R
import com.example.introvertquiz.navigation.ContentRoute

class DashboardComponent {


    @Composable
    fun TopBar(
        onSearch: () -> Unit,
        onDrawer: () -> Unit,
        modifier: Modifier = Modifier
    ) {
        Surface(
            color = MaterialTheme.colors.primary
        ) {
            Row(
                modifier = modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = CenterVertically
            ) {
                IconButton(onClick = { onDrawer.invoke() }) {
                    Box(
                        modifier = Modifier
                            .clip(CircleShape)
                            .background(Color.White.copy(0.25F))
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.dot_menu_icon),
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier
                                .padding(6.dp)
                                .size(16.dp)
                        )
                    }
                }


                IconButton(onClick = { onSearch.invoke() }) {
                    Icon(
                        painter = painterResource(id = R.drawable.search_icon),
                        contentDescription = null,
                        tint = Color.White
                    )
                }
            }
        }
    }

    @OptIn(ExperimentalMaterialApi::class)
    @Composable
    fun MainCard(
        title: String,
        desc: String,
        date: String,
        onClick: () -> Unit
    ) {
        Surface(
            color = Color.White,
            modifier = Modifier
                .width(300.dp),
            elevation = 4.dp,
            shape = RoundedCornerShape(15.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(11.dp)
            ) {
                Row(
//                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column {
                        Text(
                            text = title,
                            style = MaterialTheme.typography.body1,
                            color = Color.Black,
                            fontSize = 14.sp
                        )
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(
                            text = desc,
                            style = MaterialTheme.typography.h1,
                            color = Color.Black,
                            fontSize = 14.sp
                        )
                    }
                    Image(
                        painter = painterResource(id = R.drawable.logo_telkom_main_card),
                        contentDescription = null,
                        modifier = Modifier
                            .size(29.dp)
                    )
                }
                Spacer(
                    modifier = Modifier
                        .height(15.dp)
                )


                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column {
                        Surface(
                            shape = RoundedCornerShape(15.dp),
                            color = MaterialTheme.colors.primary
                        ) {
                            Text(
                                text = "23:59",
                                style = MaterialTheme.typography.h1,
                                color = Color.White,
                                fontSize = 12.sp,
                                modifier = Modifier
                                    .padding(start = 9.dp, end = 9.dp, top = 3.dp, bottom = 3.dp)
                            )
                        }
                        Spacer(modifier = Modifier.height(6.dp))
                        Text(
                            text = date,
                            style = MaterialTheme.typography.body1,
                            color = MaterialTheme.colors.primary,
                            fontSize = 14.sp
                        )
                    }


                    Surface(
                        shape = RoundedCornerShape(15.dp),
                        color = MaterialTheme.colors.primary,
                        elevation = 6.dp,
                        onClick = {
                            onClick.invoke()
                        },
                        modifier = Modifier.offset(y=8.dp)
                    ) {
                        Text(
                            text = "Add Submission",
                            style = MaterialTheme.typography.h1,
                            color = Color.White,
                            fontSize = 10.sp,
                            modifier = Modifier
                                .padding(start = 6.dp, end = 6.dp, top = 5.dp, bottom = 5.dp)
                        )
                    }
                }
            }
        }
    }

    @Composable
    fun NewsCard(
        title: String,
        date: String
    ) {
        Surface(
            color = Color.White,
            modifier = Modifier
                .width(185.dp),
            shape = RoundedCornerShape(15.dp),
            elevation = 4.dp

        ) {
            Column(
                modifier = Modifier
                    .padding(start = 11.dp, bottom = 11.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column{
                        Image(
                            painter = painterResource(id = R.drawable.logo_telkom_universtiy),
                            contentDescription = null,
                            modifier = Modifier
                                .size(35.dp)
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(
                            text = "Admin CELOE",
                            style = MaterialTheme.typography.caption,
                            color = Color.Black,
                            fontSize = 12.5.sp,
                            modifier = Modifier.width(87.36.dp)
                        )
                    }
                    Box(
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .wrapContentWidth(End)
                                .height(48.dp)
                                .width(80.dp)
                                .shadow(8.dp, shape = CircleShape)
                        )
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .wrapContentWidth(End)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.cloud_vector_card),
                                contentDescription = null
                            )
                        }

                    }
                }
                Spacer(modifier = Modifier.height(1.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 11.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = title,
                        fontSize = 10.sp,
                        style = MaterialTheme.typography.h1,
                        color = Color.Black
                    )
                    Text(
                        text = date,
                        style = MaterialTheme.typography.h3,
                        color = MaterialTheme.colors.primary,
                        fontSize = 8.sp
                    )

                }
            }
        }
    }

    @Composable
    fun CourseCard(
        title: String,
        navController: NavController
    ) {
        val dashboardDialog = DashboardDialog()

        val showCourseDialog = remember {
            mutableStateOf(false)
        }


        Surface(
            color = MaterialTheme.colors.primary,
            shape = RoundedCornerShape(30.dp),
            elevation = 4.dp,
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    navController.navigate(ContentRoute.Materi.route)
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
                            .width(80.dp)
                            .shadow(14.dp, shape = CircleShape)
                    )
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentWidth(End)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.cloud_course_vector),
                            contentDescription = null
                        )
                    }

                    Box(
                        modifier = Modifier
                            .fillMaxHeight()
                            .wrapContentHeight(Bottom)
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
                        verticalAlignment = CenterVertically
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
                    Surface(
                        shape = RoundedCornerShape(15.dp),
                        color = Color.White,
                        elevation = 4.dp,
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 15.dp,top = 6.dp,bottom = 15.dp, end =1.dp),
                            verticalAlignment = Alignment.Bottom,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Row(
                                verticalAlignment = CenterVertically
                            ) {
                                CircleProgress()
                                Spacer(modifier = Modifier.width(9.dp))
                                Column {
                                    Text(
                                        text = title,
                                        fontSize = 12.sp,
                                        style = MaterialTheme.typography.h1,
                                        color = Color.Black
                                    )
                                    Spacer(modifier = Modifier.height(8.dp))
                                    Text(
                                        text = "9/16",
                                        fontSize = 12.sp,
                                        style = MaterialTheme.typography.h1,
                                        color = Color.Black
                                    )
                                }
                            }

                            IconButton(onClick = { showCourseDialog.value = true }, modifier = Modifier.offset(y = 10.dp,x = 2.dp)) {
                                Box {
                                    Icon(
                                        painter = painterResource(id = R.drawable.menu_icon),
                                        contentDescription = null,
                                        tint = Color.Black
                                    )

                                    if (showCourseDialog.value) {
                                        dashboardDialog.CourseDropDown(show = showCourseDialog)
                                    }
                                }
                            }

                        }
                    }
                }


            }
        }
    }


    @Composable
    fun CircleProgress() {
        val arcColor = MaterialTheme.colors.primary
        Box(
            contentAlignment = Center,
            modifier = Modifier
                .size(20.dp * 2F)
        ) {
            Box(
                modifier = Modifier
                    .size(23.dp * 2F)
                    .clip(CircleShape)
                    .background(Color.LightGray)
            )
            Box(
                modifier = Modifier
                    .size(17.dp * 2F)
                    .clip(CircleShape)
                    .background(Color.White)
            )
            Canvas(
                modifier = Modifier
                    .size(20.dp * 2F)
            ) {
                drawArc(
                    color = arcColor,
                    -90F,
                    360 * 0.6F,
                    useCenter = false,
                    style = Stroke(6.dp.toPx(), cap = StrokeCap.Round)
                )
            }

            Text(
                text = "65%",
                style = MaterialTheme.typography.h3,
                fontSize = 13.sp,
                color = MaterialTheme.colors.primary,
                modifier = Modifier
                    .padding(5.dp)
            )
        }
    }
}