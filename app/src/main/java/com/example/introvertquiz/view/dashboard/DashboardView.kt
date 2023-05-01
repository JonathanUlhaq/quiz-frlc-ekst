package com.example.introvertquiz.view.dashboard

import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.introvertquiz.R
import com.example.introvertquiz.components.DashboardComponent
import com.example.introvertquiz.components.DashboardDialog
import com.example.introvertquiz.widget.dashboard.DashboardWidget
import kotlinx.coroutines.launch

@Composable
fun DashboardView(
    navController: NavController,
    clickDrawer:() -> Unit
) {
    val dashboardComponent = DashboardComponent()
    val dashboardWidget = DashboardWidget()
    val dashboardDialog = DashboardDialog()

    val showDropTask = remember {
        mutableStateOf(false)
    }

    val showSearch = remember {
        mutableStateOf(false)
    }

    val textFiel = remember {
        mutableStateOf("")
    }

    if (showSearch.value) {
        dashboardDialog.SearchDropDown(boolean = showSearch, text = textFiel )
    }

    val scrollState = rememberScrollState()

        Scaffold(
            backgroundColor = Color.White,
            topBar = {
                dashboardComponent.TopBar(onDrawer = {
                    clickDrawer.invoke()
                }, modifier = Modifier.padding(end = 16.dp,top = 18.dp), onSearch = {
                    showSearch.value = true
                })
            }
        ) { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .padding(bottom = 16.dp)
                    .verticalScroll(scrollState)
            ) {
                Surface(
                    color = MaterialTheme.colors.primary,
                    shape = RoundedCornerShape(bottomEnd = 15.dp, bottomStart = 15.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .padding(start = 16.dp, top = 18.dp)
                    ) {
                        Text(
                            text = "Hallo",
                            style = MaterialTheme.typography.caption,
                            fontSize = 16.sp,
                            color = Color.White
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "Kurniawan",
                            style = MaterialTheme.typography.h1,
                            fontSize = 24.sp,
                            color = Color.White
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        Box {
                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = "All Upcoming Task",
                                    style = MaterialTheme.typography.h1,
                                    fontSize = 16.sp,
                                    color = Color.White
                                )
                                Spacer(modifier = Modifier.width(16.dp))

                                IconButton(onClick = { showDropTask.value = true }) {
                                    Column(
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        modifier = Modifier
                                            .offset(y = -14.dp)
                                    ) {
                                        Box(
                                            modifier = Modifier
                                                .offset(x = 8.dp)
                                                .clip(CircleShape)
                                                .background(Color.White)
                                        ) {
                                            Text(
                                                text = "3",
                                                fontSize = 15.sp,
                                                color = MaterialTheme.colors.primary,
                                                modifier = Modifier
                                                    .padding(
                                                        top = 2.dp,
                                                        bottom = 2.dp,
                                                        start = 8.dp,
                                                        end = 8.dp
                                                    ),
                                                style = MaterialTheme.typography.h1
                                            )
                                        }
                                        Spacer(modifier = Modifier.height(2.dp))
                                        Icon(
                                            painter = painterResource(id = R.drawable.icon_dropdown),
                                            contentDescription = null,
                                            tint = Color.White
                                        )
                                    }

                                }
                            }
                            dashboardDialog.TaskDropdown(show = showDropTask)
                        }
                        Spacer(modifier = Modifier.height(14.dp))
                        dashboardWidget.MainCardWidget()
                        Spacer(modifier = Modifier.height(34.dp))
                    }
                }
                Spacer(modifier = Modifier.height(10.dp))
                Column(
                    modifier = Modifier
                        .padding(start = 16.dp)
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
                                text = "Berita Terbaru",
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
                    dashboardWidget.NewsCardWidget()
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
                            text = "Course",
                            fontSize = 16.sp,
                            style = MaterialTheme.typography.h3,
                            color = Color.Black
                        )

                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentWidth(CenterHorizontally)
                            .padding(end = 16.dp)
                    ) {
                        Column {

                            dashboardWidget.CourseCardWidget(navController)
                        }
                    }

                }


            }
        }

}
